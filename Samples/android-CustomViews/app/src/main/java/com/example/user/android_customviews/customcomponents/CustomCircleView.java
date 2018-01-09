package com.example.user.android_customviews.customcomponents;

import android.annotation.SuppressLint;
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

import com.example.user.android_customviews.R;

/**
 * Created by singh on 7/26/17.
 */

public class CustomCircleView extends View {

    private static final String TAG = "Circle";
    int radius;
    int fillColor;
    int borderColor;
    int width;
    int height;


    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

//        typed array is used for retrieving the xml attributes passed from the layout file
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCircleView, 0, 0);


//        initialize the local variables with the types attributes
        radius = typedArray.getInt(R.styleable.CustomCircleView_radius, 4);
        borderColor = typedArray.getColor(R.styleable.CustomCircleView_borderColor, Color.GREEN);
        fillColor = typedArray.getColor(R.styleable.CustomCircleView_fillColor, Color.BLACK);
        typedArray.recycle();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        check for min value for radius
        int minRadius = Math.min(width / 2, height / 2);
        if (radius > minRadius) radius = minRadius;


        Paint paint = new Paint();

//        use the paint object to fill color in the circle
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(fillColor);
//        draw the circle on the canvas using paint and radius
        canvas.drawCircle(width / 2, height / 2, radius, paint);


//        use the paint object to fill color in the circle
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(borderColor);


//        draw the circle on the canvas using paint and radius
        canvas.drawCircle(width / 2, height / 2, radius, paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        setup the maximum size of the view
        int desiredWidth = 400;
        int desiredHeight = 400;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }

        setMeasuredDimension(width, height);
    }
}
