package com.example.user.android_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.android_retrofit.model.SampleJSON;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Call<SampleJSON> sampleJsonServiceCall = RetrofitHelper.getSampleJsonResponse();

        sampleJsonServiceCall.enqueue(new Callback<SampleJSON>() {
            @Override
            public void onResponse(Call<SampleJSON> call, Response<SampleJSON> response) {

                Log.d(TAG, "onResponse: " + response.body().getData().size());

            }

            @Override
            public void onFailure(Call<SampleJSON> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.toString());
            }
        });

    }
}
