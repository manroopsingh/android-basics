package com.example.user.kotlin_basicconcepts

import kotlinx.coroutines.*


fun main() {

    val dispatcherList = listOf(Dispatchers.Default, Dispatchers.Main, Dispatchers.IO, Dispatchers.Unconfined)


    println("Hello")
    GlobalScope.launch(Dispatchers.IO) {

        delay(1000L)
        println("World")
        //withContext(Dispatchers.Main){print("Thread:${Thread.currentThread().name}")}
    }
    println("After world")
//            dispatcherList.forEach {
//                executeOnDefault(it)
//            }

    runBlocking {

        println("In the running block: ${Thread.currentThread().name}")
    }



}

suspend fun executeOnDefault(dispatcher: CoroutineDispatcher) =
    withContext(dispatcher) { print(Thread.currentThread().name) }

