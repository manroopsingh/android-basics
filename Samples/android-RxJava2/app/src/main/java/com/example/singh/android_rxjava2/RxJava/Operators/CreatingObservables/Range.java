package com.example.singh.android_rxjava2.RxJava.Operators.CreatingObservables;

import com.example.singh.android_rxjava2.utils.ObserverFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by singh on 18-Sep-17.
 */

public class Range {

    public static void main(String[] args) {

        //range will create the observable which emits value from "start" to "count"
        Observable<Integer> integerObservable = Observable.range(1, 10);

        Observer<Integer> integerObserver = ObserverFactory.getIntObserver();


        integerObservable.subscribe(integerObserver);
    }
}
