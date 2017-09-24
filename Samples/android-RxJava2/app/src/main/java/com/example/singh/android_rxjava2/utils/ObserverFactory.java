package com.example.singh.android_rxjava2.utils;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by singh on 23-Sep-17.
 */

public class ObserverFactory {

    public static Observer<Integer> getIntObserver(){
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("onNext: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onCompleted: ");
            }
        };

    }

    public static Observer<String> getStringObserver(){
        return new Observer<String>(){
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onCompleted: ");
            }
        };

    }

    public static Observer<Long> getLongObserver(){
        return new Observer<Long>(){
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull Long aLong) {
                System.out.println("onNext: " + aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onCompleted: ");
            }
        };

    }

}
