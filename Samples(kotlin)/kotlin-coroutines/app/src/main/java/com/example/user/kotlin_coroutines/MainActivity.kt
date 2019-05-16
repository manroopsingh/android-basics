package com.example.user.kotlin_coroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(){

    val activityJob = Job()
    val activityScope = CoroutineScope(Dispatchers.Main + activityJob)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        printTime("runBlocking", this) {
            runBlocking {
                delay(DELAY_TIME)
                printThread("runBlocking", this)
            }
        }

        btnDoSomething.setOnClickListener {
            testingGlobalScope()
            testingActivityScope()

        }

    }

    fun testingGlobalScope() {
        GlobalScope.launch {
            delay(DELAY_TIME)
            printThread("GlobalScope default launch", this)
            withContext(Dispatchers.IO){
                printThread("withContext IO", this)
            }
        }
    }

    fun testingActivityScope() {

        activityScope.launch {
            delay(DELAY_TIME)
            printThread("activityScope default launch", this)
            withContext(Dispatchers.Unconfined){
                printThread("withContext UnConfined", this)}
        }

    }

    override fun onStop() {
        super.onStop()
        activityJob.cancel()
    }

}
