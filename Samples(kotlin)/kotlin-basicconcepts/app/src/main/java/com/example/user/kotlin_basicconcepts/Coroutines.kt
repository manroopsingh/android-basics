package com.example.user.kotlin_basicconcepts

import kotlinx.coroutines.*


suspend fun main() {

    //we are not using the Dispatcher.MAIN since that will be running on the Android context, not JVM`
    val dispatcherList = listOf(Dispatchers.Default, Dispatchers.IO, Dispatchers.Unconfined)

    println("Start")
    GlobalScope.launch {

        println("Dispatchers start")
        dispatcherList.forEach {
            executeOnDefault(it)
        }
    }
    println("Dispatched")

    GlobalScope.async {
        delay(1000L)
        println("Async block Thread: ${Thread.currentThread().name}")
    }

/*  runBlocking{}

    Almost never used in the execution of the app, since it would RUN BLOCKING the current thread
    to get result from the suspending function. The most use cases of using this block would be for
    testing. If we have to test a suspending function then we can use this block to wait for the
    suspending function to assert the result of the function.
*/
    runBlocking {
        println("Running block thread: ${Thread.currentThread().name}")
    }

      //used to read the prints
    Thread.sleep(dispatcherList.size * 1000L + 1000L)

    println("Stop")

}

suspend fun executeOnDefault(dispatcher: CoroutineDispatcher) =
    withContext(dispatcher) {
        delay(1000)
        println("Name: $dispatcher Thread: ${Thread.currentThread().name}")
    }