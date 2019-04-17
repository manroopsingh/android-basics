package com.example.user.kotlin_basicconcepts

//  traditional way to create the callback
interface Callback {
    fun onCallBack(result: String)
}

fun main() {

//    creating lambdas for different operations
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    println(applyOp(2, 3, sum))
    val mul = { x: Int, y: Int -> x * y }
    println(applyOp(2, 3, mul))

//    in kotlin if the lambda is the last argument, you can extract out the lambda
//    outside the function parameters and call the lambda
    applyOp(2, 3) { d, f -> d - f }


//    traditional way to call the method with the callback
    doAsync(20, object : Callback {
        override fun onCallBack(result: String) {
            println(result)
        }
    })

//    kotlin way to pass the execution of the argument to a lambda
    doAsyncWithLambda(20) { result -> println(result) }

}

fun doAsync(x: Int, callback: Callback) {
    callback.onCallBack("You passed: $x")
}

fun doAsyncWithLambda(x: Int, callback: (String) -> Unit) {
    callback("You passed: $x")
}

fun applyOp(x: Int, y: Int, f: (Int, Int) -> Int): Int = f(x, y)

inline fun twice(crossinline f: (Int)->Int): (Int) -> Int = {x-> f(f(x))}

//writing your DSL with Lambdas and Extension function
fun <T> T.apply2(f: T.() -> Unit): T {
    f()
    return this
}

