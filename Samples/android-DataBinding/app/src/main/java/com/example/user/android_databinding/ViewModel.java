package com.example.user.android_databinding;

import android.util.Log;
import android.view.View;

/**
 * Created by singh on 7/25/17.
 */

public class ViewModel {


    private static final String TAG = "ViewModel";

    public void doSomething(View view) {
        Log.d(TAG, "doSomething: ");
    }

    public void doSomethingWithPerson(View view, Person person) {
        Log.d(TAG, "doSomethingWithPerson: " + person.getFirstName() + " " + person.getLastName());
    }


    public void updatePerson(View view, Person person){

        Log.d(TAG, "updatePerson: " + person.getfName().get() + " " +person.getlName().get());

    }

}
