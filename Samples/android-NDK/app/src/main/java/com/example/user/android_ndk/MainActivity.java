package com.example.user.android_ndk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private TextView tvMain;
    private MeshData meshData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bind view
        tvMain = findViewById(R.id.tvString);
    }

    public void onStringFromNative(View view) {
//        get string value from the native code
        Log.d(TAG, "onStringFromNative: ");
        tvMain.setText(NativeHelper.stringFromJNI());
    }


    public void onCreateMeshDataFromNative(View view) {
        Log.d(TAG, "onCreateMeshDataFromNative: ");
        meshData = NativeHelper.createObjectFromNative(4);
        tvMain.setText(meshData.toString());

    }

    public void onGetMemberFieldFromNative(View view) {
        Log.d(TAG, "onCreate: calculate result: " + NativeHelper.getMemberFieldFromNative(meshData));
        tvMain.setText(String.valueOf(NativeHelper.getMemberFieldFromNative(meshData)));
    }

    public void onInvokeMemberFunctionFromNative(View view) {
        Log.d(TAG, "onCreate: getFacetValue: " + NativeHelper.invokeMemberFunctionFromNative(meshData));
        tvMain.setText(String.valueOf(NativeHelper.invokeMemberFunctionFromNative(meshData)));

    }

    public void onCreateObjectArrayFromNative(View view) {
        MeshData[] meshArray = new MeshData[4];

        for (int i = 0; i <meshArray.length; i++) {
            meshArray[i] = NativeHelper.createObjectFromNative(i);
            Log.d(TAG, "onCreate: " + meshArray[i].getFacetCount());
        }

        //Log.d(TAG, "onCreate: Get facets array" + NativeHelper.processObjectArrayFromNative(meshArray));

    }
}
