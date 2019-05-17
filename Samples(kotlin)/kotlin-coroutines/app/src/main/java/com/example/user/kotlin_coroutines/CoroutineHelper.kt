package com.example.user.kotlin_coroutines

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


const val DELAY_TIME = 2000L
inline fun <T> printTime(tag: String, t: T, block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val totalTime = System.currentTimeMillis() - start
    Log.d(t?.toString(), "printTime for: $tag, Time: $totalTime")
}

fun <T> printThread(tag: String, t: T) {
    Log.d(t?.toString(), "printThread for: $tag, Thread: ${Thread.currentThread().name}")

}

suspend fun customDelay(moreTime: Long) = withContext(Dispatchers.IO) {
    delay(DELAY_TIME + moreTime)
    printThread("customDelay", this)
}