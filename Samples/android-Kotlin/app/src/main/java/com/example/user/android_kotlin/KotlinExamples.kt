package com.example.user.android_kotlin
/**
 * Created by singh on 9/8/17.
 */

object KotlinExamples {

    //Requires a main function to execute functions
    @JvmStatic
    fun main(args: Array<String>) {

        //using the arguments before hitting run
        if (args.size!==0) {
            printOutFromTheMain(args)
            printOutArrayFromTheMain(args)
            printOutMultipleLanguage(args)
        }


        //Call a method from the inner Greeter class
        Greeter("John Doe").greet()

        //print bigger number

    }

    //function to check
    fun max(a: Int, b: Int) = if (a>b) a else b


    //create an inner class to use the method
    class Greeter(private val name:  String){

        fun greet(){
            println("Hello, $name")
        }
    }

    //print the first argument passed to the main function
    private fun printOutFromTheMain(args: Array<String>) {
        if (args.isEmpty()) {
            println("Please provide a name as a command-line argument")
            return
        }
        println("Hello, ${args[0]}!")
    }

    //print the list of arguments received to the main function
    private fun printOutArrayFromTheMain(args: Array<String>){
        for (name in args)
            println("Hello, $name!")
    }

    //print the greeting in selected language
    private fun printOutMultipleLanguage(args: Array<String>){

        val language = if (args.isEmpty()) "EN" else args[0]
        println(when (language){
            "EN" -> "Hello"
            "FR" -> "Salut"
            "IT" -> "Ciao"

            else -> "Sorry, I cant talk in $language yet"
        })

    }


}


