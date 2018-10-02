package com.example.user.android_ndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.annotation.Native;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = findViewById(R.id.tvString);
        Log.d(TAG, "onCreate: TextTAg" );
        tv.setText("Default");



        Log.d(TAG, "onCreate: Get String from native: " + NativeHelper.stringFromJNI());

        tv.setText(NativeHelper.stringFromJNI());
        MeshData meshData = NativeHelper.createObjectFromNative(4);

        Log.d(TAG, "onCreate: calculate result: " + NativeHelper.getMemberFieldFromNative(meshData));

        Log.d(TAG, "onCreate: getFacetValue: " + NativeHelper.invokeMemberFunctionFromNative(meshData));

        MeshData[] meshArray = new MeshData[4];
        for (int i = 0; i < meshArray.length; i++) {
            meshArray[i] = NativeHelper.createObjectFromNative(i);
            Log.d(TAG, "onCreate: "+ meshArray[i].getFacetCount());
        }

        //Log.d(TAG, "onCreate: Get facets array" + NativeHelper.processObjectArrayFromNative(meshArray));

    }

    public void onStringFromNative(View view) {

        tv.setId(R.id.tvNew);
        TextView tvNew = findViewById(R.id.tvNew);
        tvNew.setText("New");
    }
}
