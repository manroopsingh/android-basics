package com.example.user.kotlin_coroutines

import android.util.Log


const val DELAY_TIME = 2000L
inline fun<T> printTime(tag: String, t:T, block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val totalTime = System.currentTimeMillis() - start
    Log.d(t?.toString(), "printTime for: $tag, Time: $totalTime")
}

fun <T> printThread(tag: String, t: T) {
    Log.d(t?.toString(), "printThread for: $tag, Thread: ${Thread.currentThread().name}")

}