package com.example.myapplication.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomButton  extends android.support.v7.widget.AppCompatButton implements View.OnClickListener{

    public CustomButton(Context context) {
        super(context);
        init();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "Clicked"
                , Toast.LENGTH_SHORT).show();


    }
}
