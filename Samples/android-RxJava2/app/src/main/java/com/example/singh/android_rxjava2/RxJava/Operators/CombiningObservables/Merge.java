package com.example.singh.android_rxjava2.RxJava.Operators.CombiningObservables;

import com.example.singh.android_rxjava2.utils.ObserverFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by singh on 23-Sep-17.
 */

public class Merge {

    public static void main(String[] args) {


        Observable<Integer> integerObservable1 = Observable.just(1,2,3);
        Observable<Integer> integerObservable2 = Observable.just(4,5,6);

        Observer<Integer> integerObserver = ObserverFactory.getIntObserver();

        Observable.merge(integerObservable1, integerObservable2)
                .subscribe(integerObserver);


    }
}
