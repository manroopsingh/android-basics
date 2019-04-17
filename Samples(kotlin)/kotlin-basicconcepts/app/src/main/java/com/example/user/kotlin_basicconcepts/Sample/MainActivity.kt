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


class MainActivity : AppCompatActivity() {


    //    works as static in java, but can extend other class to have common functionality
    companion object {
        var string: String = "DefaultValue"
    }

    val adapter = MediaAdapter(emptyList()) { navigateToDetail(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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

        GlobalScope.launch {
            val catsMedia = async (Dispatchers.IO){  MediaProvider.dataSync("cats")}//using the async block
            val natureMedia = getData("nature") //method on IO thread
            withContext(Dispatchers.Main) { updateAdapter(catsMedia.getCompleted() + natureMedia, filter) }//method on UI thread

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


    /*
    Toast is a function that is displaying a text using the Toast class
    */
    //Below Toast function is added to the extension.kt to use the function in all context classes
//    private fun toast(s: String) {
//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
//    }


}
