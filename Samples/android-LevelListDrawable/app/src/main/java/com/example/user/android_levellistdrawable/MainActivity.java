package com.example.user.android_levellistdrawable;

import android.graphics.drawable.LevelListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        LevelListDrawable levelListDrawable = (LevelListDrawable) imageView.getBackground();
        levelListDrawable.setLevel(1);
        //imageView.setImageLevel(1);

    }
}
