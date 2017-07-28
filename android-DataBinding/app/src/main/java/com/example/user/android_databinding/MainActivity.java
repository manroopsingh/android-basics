package com.example.user.android_databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.android_databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //remove this setContent
        //setContentView(R.layout.activity_main);

        ActivityMainBinding binding =DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPerson(new Person("Manroop" ,"Singh"));
        binding.setViewmodel(new ViewModel());

    }
}
