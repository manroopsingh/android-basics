package com.example.user.android_kotlinfeatures

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.user.android_kotlinfeatures.extention_functions.Person
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger


class MainActivity : AppCompatActivity() {

    var person: Person? = null

    companion object {
        val LOG = Logger.getLogger(MainActivity::class.java.name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initialize the person class with primary constructor
//        person = Person("John Doe")

//        initialize the person class with companion object
        person = Person.getInstance()

        LOG.info("Person:" + person.toString())

        tvPersonName.text = person?.name


        var user = User(null, null)

//        TODO:12/6/18 test user by making it null
//        user?.let { user = null }
        LOG.info("User:"+user.age)

    }

    //    extension function of person class
    fun Person.walk() {

        this.name = "$name is Walking"

    }

    //    button click for person walk
    fun onPersonWalk(view: View) {
//        call to the extension function
        person?.walk()
        LOG.info("Person: " + person?.name)
    }


    fun onTestPersonSingleton(view: View) {

//        make second instance of the person class to test
//        if the person class is singleton
        var person1 = Person.getInstance()

//        log the person1 instance
        LOG.info(person1.toString())


    }

    fun onPrintLoop(view: View){

        for(i in 10 downTo 0 step 1){
            LOG.info("Value of i: "+i)
        }
    }

    fun onSwitch(view: View){

        var i = 5
        when(i){
            in 1..5 -> LOG.info("Value of i in range")
            in 6..10 -> LOG.info("Value of i not in range")
        }
    }


}
