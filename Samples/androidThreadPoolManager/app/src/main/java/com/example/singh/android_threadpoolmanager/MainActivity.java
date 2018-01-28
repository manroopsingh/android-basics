package com.example.singh.android_threadpoolmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    private ProgressBar progressBar3;
    private ProgressBar progressBar4;
    private List<ProgressBar> progressBars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        addBarsToList();
    }

    private void addBarsToList() {
        progressBars = new ArrayList<>();
        progressBars.add(progressBar1);
        progressBars.add(progressBar2);
        progressBars.add(progressBar3);
        progressBars.add(progressBar4);
    }

    private void bindViews() {
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar4 = findViewById(R.id.progressBar4);
    }

    public void onTasksStart(View view) {

        for (ProgressBar progressBar : progressBars) {
            ProgressThreadManager.instance.startDownload(progressBar, new Random().nextInt(10));
        }

    }
}
