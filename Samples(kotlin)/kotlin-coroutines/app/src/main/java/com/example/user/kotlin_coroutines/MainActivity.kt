package com.example.user.kotlin_coroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    var activityJob = Job()
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
            //testingGlobalScope()
            testingActivityScope()

        }

    }

    fun testingGlobalScope() {
        startSampleJob("GlobalScope", GlobalScope)
    }


    /**
     * The activity scope is going to be cancel the coroutines if the activity
     * if not on the foreground.
     *
     * Test the application by clicking the button "Do Something" and then moving
     * away from the activity. You would notice that the coroutine after the delay
     * is never executed.
     */

    private fun testingActivityScope() {

        startSampleJob("activityScope", activityScope)

    }

    /**
     * Cancelling the children on the onStop method on the activity would cancel
     * all the Coroutines running on that job. It would not cancel the job object itself
     * so the doSomething button click would be able to restart the job
     */

    override fun onStop() {
        super.onStop()
        activityJob.cancelChildren()
    }


    private fun startSampleJob(scopeName: String, scope: CoroutineScope) {
        scope.launch {
            async { customDelay(1_000) }
            customDelay(0)
            printThread("$scopeName before delay", this)//runs on the main thread

            delay(DELAY_TIME)//suspending function to cause a delay
            printThread("$scopeName default launch", this)
            withContext(Dispatchers.Unconfined) {
                printThread("withContext UnConfined", this)
            }
            withContext(Dispatchers.IO) {
                printThread("withContext IO", this)
            }
        }
    }

}
