package com.example.singh.android_recyclerview;

import android.media.Image;

/**
 * Created by singh on 13-Sep-17.
 */

public class DummyData {

    String someText;
    Image someImage;

    public DummyData(String someText, Image someImage) {
        this.someText = someText;
        this.someImage = someImage;
    }

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    public Image getSomeImage() {
        return someImage;
    }

    public void setSomeImage(Image someImage) {
        this.someImage = someImage;
    }
}
