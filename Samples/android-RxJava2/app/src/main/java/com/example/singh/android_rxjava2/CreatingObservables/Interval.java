package com.example.singh.android_rxjava2.CreatingObservables;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by singh on 18-Sep-17.
 */

public class Interval {

    public static void main(String[] args) throws InterruptedException {


        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);


        Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Long aLong) {

                System.out.println("onNext: " + aLong + " onThread: " + Thread.currentThread());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);

        Thread.sleep(5000);

        System.out.println("Current Thread" + Thread.currentThread());
    }
}
