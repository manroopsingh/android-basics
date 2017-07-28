package com.example.user.android_testing;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.security.AllPermission;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainACtivityTag";
    public static final String KeyExtra = "key";

    @BindView(R.id.textview)
    TextView textView;

    @BindView(R.id.edittext)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");


        //StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());


        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void doMagic(){

        textView.setText(editText.getText().toString());


    }

    @OnClick(R.id.buttonIntent)
    public void doIntentMagic(){

        Intent intent   = new Intent(this, SecondActivity.class);
        intent.putExtra(KeyExtra,editText.getText().toString());
        startActivity(intent);


    }


}
