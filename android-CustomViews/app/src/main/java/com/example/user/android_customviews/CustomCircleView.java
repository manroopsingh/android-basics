package com.example.user.android_customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by singh on 7/26/17.
 */

public class CustomCircleView extends View {

    private static final String TAG = "Circle";
    int radius;
    int colorValue;

    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCircleView, 0, 0);
        radius = typedArray.getInt(R.styleable.CustomCircleView_radius, 4);
        colorValue = typedArray.getColor(R.styleable.CustomCircleView_borderColor, 0);

        typedArray.recycle();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint paint = new Paint();
        paint.setColor(colorValue);

        canvas.drawCircle(200, 200, radius, paint);


        Rect rect = new Rect();
        rect.left = 10;
        rect.right = 10;
        rect.top = rect.left+10;
        rect.bottom = rect.top +10;
        Paint paint1 = new Paint(Color.GREEN);
        canvas.drawRect(rect, paint1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        Log.d(TAG, "onMeasure: " + widthMeasureSpec + ":" + heightMeasureSpec);

        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);

    }
}
