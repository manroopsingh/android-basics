package com.example.singh.android_recyclerview;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by singh on 13-Sep-17.
 */

public class DummyData {

    String someText;

    Bitmap someImage;

    public DummyData(String someText, Bitmap someImage) {
        this.someText = someText;
        this.someImage = someImage;
    }

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    public Bitmap getSomeImage() {
        return someImage;
    }

    public void setSomeImage(Bitmap someImage) {
        this.someImage = someImage;
    }
}
