package com.example.singh.android_mvp.utils;

/**
 * Author: singh on: 19-Dec-17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();


}
