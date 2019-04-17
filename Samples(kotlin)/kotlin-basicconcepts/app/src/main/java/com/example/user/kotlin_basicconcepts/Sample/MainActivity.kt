package com.example.user.kotlin_basicconcepts.Sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.user.kotlin_basicconcepts.R
import com.example.user.kotlin_basicconcepts.apply2
import com.example.user.kotlin_basicconcepts.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.startActivity
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume


class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    //    works as static in java, but can extend other class to have common functionality
    companion object {
        var string: String = "DefaultValue"
    }

    val adapter = MediaAdapter(emptyList()) { navigateToDetail(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        job = Job()


        toast("This is the default text")//function call to toast method
        val textView: TextView = findViewById(R.id.textView)//bind the textview
        textView.text = "Hello Kotlin"//assign a value to the text using properties not setText()

        /*
        Bind the views to show the toast from an EditText from the button click
        */
        val editText: EditText = findViewById(R.id.message)

        var button: Button = findViewById(R.id.button)

        /*
        For single method interfaces, we can use lambdas to put the block on code in the
        method definition.

        String template
        We are also using a string template in the method call us concatenate the strings
        before and after the EditText value
        */
        button.setOnClickListener { toast("Hello ${editText.text}, how are you doing") }


        //bind the RecyclerView
        //val recyclerView: RecyclerView = findViewById(R.id.recycler)
        recycler.layoutManager = GridLayoutManager(this, 2)

//
//        recycler.adapter = MediaAdapter(getMedia()){(title) -> toast(title) }

        recycler.adapter = adapter
        MediaProvider.dataAsync { adapter.items = it }


        //example of using your own standard function using Lambda and Extension function (Lambdas.kt)
        val textView2 = TextView(this).apply2 {
            text = "Something else"
        }

    }

    private fun navigateToDetail(item: MediaItem) {

        startActivity<DetailActivity>(DetailActivity.ID to item.id)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val filter: Filter = when (item.itemId) {
            R.id.filter_videos -> Filter.ByType(MediaItem.Type.VIDEO)
            R.id.filter_photos -> Filter.ByType(MediaItem.Type.PHOTO)
            else -> Filter.None
        }

        loadFilteredMedia(filter)
        return true
    }


    private fun loadFilteredMedia(filter: Filter) {

        //GlobalScope.launch (Dispatchers.Main){  }
        /*
        The above code is refactored to just launch since the current activity is using a custom activity scope since
        the activity is implementing a coroutine scope. And managing the scopes in the lifecycle methods would stop the
        asynchronous tasks if the activities are destroyed
        */
        launch{
            /*Async block
            This block would not block the parent block but would run the job in parallel. We can also set the async
            to be started when the await() method is called. It would return a Deferred object which extends Job
            */
            val catsMedia = async (Dispatchers.IO, CoroutineStart.LAZY){  MediaProvider.dataSync("cats")}

            //Here getData is using a suspending function to get the data from the worker thread
            val natureMedia = getData("nature") //method on IO thread

            //Suspending function to replace the callback system with coroutine
            val otherMedia = dataAsync()

            updateAdapter(catsMedia.await() + natureMedia, filter)//method on UI thread since the parent is MAIN

        }
    }

    suspend fun dataAsync(): List<MediaItem> = suspendCancellableCoroutine {continuation ->
        MediaProvider.dataAsync {media ->
            continuation.resume(media)
        }
    }


/*
     suspending functions are used for decoupling the async code into a different method
*/
    private suspend fun getData(type: String) = withContext(Dispatchers.IO) {
        MediaProvider.dataSync(type)
    }

    private fun updateAdapter(items: List<MediaItem>, filter: Filter) {

        print("Size${items.size}")
        items.forEach { print(it.thumbUrl) }
        adapter.items = when (filter) {
            is Filter.None -> items
            is Filter.ByType -> items.filter { it.type == filter.type }
        }
    }

    sealed class Filter {
        object None : Filter()
        class ByType(val type: MediaItem.Type) : Filter()
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    /*
    Toast is a function that is displaying a text using the Toast class
    */
    //Below Toast function is added to the extension.kt to use the function in all context classes
//    private fun toast(s: String) {
//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
//    }


}
