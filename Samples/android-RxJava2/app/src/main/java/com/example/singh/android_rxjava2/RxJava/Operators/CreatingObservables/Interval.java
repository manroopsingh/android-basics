package com.example.singh.android_rxjava2.RxJava.Operators.CreatingObservables;

import com.example.singh.android_rxjava2.utils.ObserverFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by singh on 18-Sep-17.
 */

public class Interval {

    public static void main(String[] args) throws InterruptedException {


//      interval operator creates an observable
//      that emits a sequence of integers spaced by a particular time interval
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);


        Observer<Long> longObserver = ObserverFactory.getLongObserver();

        observable.subscribe(longObserver);

        Thread.sleep(5000);
}
}
