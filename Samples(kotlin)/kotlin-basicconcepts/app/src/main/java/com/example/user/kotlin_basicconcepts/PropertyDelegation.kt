package com.example.user.kotlin_basicconcepts

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlin.properties.Delegates

class PropertyDelegation(val activity: Activity){

//    1. Lazy
    val recyclerView by lazy { activity.findViewById(R.id.recycler) as RecyclerView}

//    2. Observable
    val observableNumber by Delegates.observable(0){ property, oldValue, newValue ->
    Log.d("observedNumber", "old value: $oldValue, new value: $newValue")

//    3. Vetoable
    val positiveNumber by Delegates.vetoable(0){property, oldValue, newValue ->
        newValue>=0
    }

//    4. Lateinit (will be injected from a dependency injection or injected at a later time)
    lateinit var recyclerView: RecyclerView
}

}