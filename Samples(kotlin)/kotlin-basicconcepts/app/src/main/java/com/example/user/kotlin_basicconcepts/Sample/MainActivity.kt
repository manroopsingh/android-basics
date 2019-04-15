package com.example.user.kotlin_basicconcepts.Sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.user.kotlin_basicconcepts.R
import com.example.user.kotlin_basicconcepts.apply2
import com.example.user.kotlin_basicconcepts.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //    works as static in java, but can extend other class to have common functionality
    companion object {
        var string: String = ""
    }

    val adapter = MediaAdapter(emptyList()) { (title) -> toast(title) }

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        MediaProvider.dataAsync { media ->
            adapter.items =
                when (item.itemId) {
                    R.id.filter_all -> media
                    R.id.filter_photos -> media.filter { it.type == MediaItem.Type.PHOTO }
                    R.id.filter_videos -> media.filter { it.type == MediaItem.Type.VIDEO }

                    else -> emptyList()
                }
        }


        return true
    }

    /*
    Toast is a function that is displaying a text using the Toast class
    */
    //Below Toast function is added to the extension.kt to use the function in all context classes
//    private fun toast(s: String) {
//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
//    }


}
