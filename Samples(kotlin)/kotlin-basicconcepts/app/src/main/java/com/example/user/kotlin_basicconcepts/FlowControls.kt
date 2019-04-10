package com.example.user.kotlin_basicconcepts



fun main() {

/*
 "when" expression is similar to switch, but when is more powerful than a switch.
 Since, when is an expression you can save the value into a variable or concatenate with another string
*/
    println(test(4))
    println(test(23))
    println(test(35))
    println(test(45))
    println(test(55))
}


fun test(int: Int) :String  {

    val fortyToFiftyRange = 40..50

    return "$int: " + when (int) {
        in 1..10 -> "Positive number less than 10"
        in 20..30 -> "Lies in 10 to 20 range"
        35 -> "Number is 35"
        in fortyToFiftyRange -> "Lies in 40 to 50 range"

        else -> "Out of range"
    }
}