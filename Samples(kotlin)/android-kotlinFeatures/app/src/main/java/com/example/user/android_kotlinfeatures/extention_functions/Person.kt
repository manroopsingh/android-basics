package com.example.user.android_kotlinfeatures.extention_functions

//primary private constructor
class Person private constructor(var name: String){

    //make a person class to be singleton
    init {
        name = "Default Name changed by secondary"
    }

    companion object {

        private val instance: Person = Person("Default name")

        fun getInstance(): Person{
            return instance
        }
    }
}