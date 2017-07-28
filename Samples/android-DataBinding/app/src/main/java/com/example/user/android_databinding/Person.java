package com.example.user.android_databinding;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by singh on 7/25/17.
 */

public class Person {

    String firstName;
    String lastName;


    ObservableField<String> lName = new ObservableField<>();
    ObservableField<String> fName = new ObservableField<>();


    public TextWatcher watcherFirstName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }

        @Override
        public void afterTextChanged(Editable editable) {

            fName.set(editable.toString());
        }
    };


    public TextWatcher watcherLastName= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            lName.set(editable.toString());
        }
    };

    public ObservableField<String> getlName() {
        return lName;
    }

    public ObservableField<String> getfName() {
        return fName;
    }


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
