package com.example.user.android_animations;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tvMain);


    }

//    using value animator
    public void onTextViewAnimate(View view) {

        ValueAnimator valueAnimator = null;

        switch (view.getId()) {
            case R.id.btnAnimateWithJava:

                valueAnimator = ValueAnimator.ofFloat(0f, 500f);
                valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimator.setDuration(2000);

                break;
            case R.id.btnAnimateWithXML:

                valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value_animator_tvmain);

                break;
        }

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float progress = (float) valueAnimator.getAnimatedValue();
                tvMain.setTranslationY(progress);

            }
        });

        valueAnimator.start();
    }
}
