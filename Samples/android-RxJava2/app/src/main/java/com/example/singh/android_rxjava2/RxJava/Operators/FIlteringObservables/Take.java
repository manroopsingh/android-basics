package com.example.singh.android_rxjava2.RxJava.Operators.FIlteringObservables;

import com.example.singh.android_rxjava2.utils.ObserverFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by singh on 23-Sep-17.
 */

public class Take {

    public static void main(String[] args) {

        Observable<Integer> integerObservable = Observable.range(1, 10);

        Observer<Integer> integerObserver = ObserverFactory.getIntObserver();

        integerObservable
                .take(5)
                .subscribe(integerObserver);


    }
}
