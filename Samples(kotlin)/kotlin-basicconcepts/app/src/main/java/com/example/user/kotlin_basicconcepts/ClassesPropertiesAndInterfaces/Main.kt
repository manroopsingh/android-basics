package com.example.user.kotlin_basicconcepts.ClassesPropertiesAndInterfaces


fun main() {

    val person4 = Test.Person4()

//    printing the name of the person with default value
    println(person4.name)

//    create a person object with naming the param in the constructor
    val p4 =
        Test.Person4(age = 79, name = "Thomas")//this way we can rearrange the params for the class initialization
    println(p4.toString())//Person4 class have a custom


}
