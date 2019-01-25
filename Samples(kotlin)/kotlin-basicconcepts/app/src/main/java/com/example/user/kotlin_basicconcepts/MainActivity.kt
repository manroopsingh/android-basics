package com.example.user.kotlin_basicconcepts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast("This is the default text")

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


}
