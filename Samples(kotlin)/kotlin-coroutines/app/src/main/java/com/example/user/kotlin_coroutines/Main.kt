package com.example.user.kotlin_coroutines

import kotlinx.coroutines.*


fun main() {

    GlobalScope.launch{
        withContext(Dispatchers.IO) {
            delay(1000)
            println(Thread.currentThread().name) }
        withContext(Dispatchers.Default) { println(Thread.currentThread().name)}
        withContext(Dispatchers.Unconfined) { println(Thread.currentThread().name)}
    }
    Thread.sleep(2000)

}
