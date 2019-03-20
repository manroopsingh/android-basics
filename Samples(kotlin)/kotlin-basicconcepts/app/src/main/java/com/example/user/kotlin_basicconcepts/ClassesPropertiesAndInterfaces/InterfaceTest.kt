package com.example.user.kotlin_basicconcepts.ClassesPropertiesAndInterfaces

import android.util.Log


class LoggerTest: Logger{

    fun Main(){


        d("This is the message")


    }

}

interface Logger{

    val tag: String
    get() = javaClass.simpleName

    fun d(message: String) = Log.d(tag, message)

}


