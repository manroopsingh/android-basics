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

    var mutableString = "changeable"//var is using for variable that can be changed
    val immutableString = "not changeable"//val is used for value that cant be changed

    val sampleInt: Int = 0//using : Int we can declare the type variable we are declaring
    /*
    Using Type Inference in Kotlin, we don't have the specify the type of the variable,
    the compiler would know the type based on the value assigned
    */
    val intValue = 10
    val longValue = 10L
    val floatValue = 10f
    val decimalValue = 10.0

    /*
    Every type in kotlin is an object, in order to convert a type to another we have to use
    the provided functions with each type to convert to the given type
    For Example, the longValue can be converted to the int value (newIntValue) as below
    */
    var newIntvalue = longValue.toInt()


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

    In kotlin all functions return an object
    if you do not specify an return type, its the same
    as returning : Unit
    For Example, the below are the same functions
    private fun toast(message: String) {}

    private fun toast(message: String) : Unit{
    }

    "Unit" represents as "void" in java

    */
    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    /*
    Making a new function in kotlin

    @myInt : name of the param being used in the function
    @Int: type of the param "myInt" and the return type of the function as well
    */

    fun myFunction(myInt: Int): Int {
        print("Hello")//this is how you can print a string to the console
        return myInt
    }

    /*
    Because of Type Inference, we can remove the "return in a single line function
    for more concise language.
    */
    fun getInt(myInt: Int) = 2 * myInt


}
