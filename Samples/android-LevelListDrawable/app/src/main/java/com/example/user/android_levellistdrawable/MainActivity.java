package com.example.user.android_levellistdrawable;

import android.graphics.drawable.LevelListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private ImageView imageView;
    private LevelListDrawable levelListDrawable;
    public static final int IMAGE_LEVELS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        imageView = (ImageView) findViewById(R.id.imageView);
        levelListDrawable = (LevelListDrawable) imageView.getBackground();

    }

    public void changeImage(View view) {


        int randomLevel = getRandomLevel();
        int currentLevel = levelListDrawable.getLevel();

        Log.d(TAG, "changeImage: Current:" + currentLevel);
        Log.d(TAG, "changeImage: Random:" + randomLevel);
        while(currentLevel == randomLevel){
            randomLevel = getRandomLevel();
        }



        levelListDrawable.setLevel(randomLevel);

    }

    private int getRandomLevel() {
        return new Random().nextInt(IMAGE_LEVELS);
    }
}
