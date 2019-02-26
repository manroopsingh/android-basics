package com.example.user.kotlin_basicconcepts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {



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


    }

    /*
    Toast is a function that is displaying a text using the Toast class
    */
    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }



}
