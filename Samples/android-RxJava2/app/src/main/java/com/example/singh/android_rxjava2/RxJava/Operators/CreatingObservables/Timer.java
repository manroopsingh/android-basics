package com.example.singh.android_rxjava2.RxJava.Operators.CreatingObservables;

import com.example.singh.android_rxjava2.utils.ObserverFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by singh on 23-Sep-17.
 */

public class Timer {

    public static void main(String[] args) throws InterruptedException {

/*
        timer operator will emit a single value after the given delay
*/

        Observable<Long> observable = Observable.timer(1, TimeUnit.SECONDS);

        Observer<Long> longObserver = ObserverFactory.getLongObserver();


        observable.subscribe(longObserver);
//
//        Thread sleep is used to display the result for the delayed emission
//

        Thread.sleep(2000);



    }
}
