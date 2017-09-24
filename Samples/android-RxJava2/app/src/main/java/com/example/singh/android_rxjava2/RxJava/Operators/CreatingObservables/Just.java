package com.example.singh.android_rxjava2.RxJava.Operators.CreatingObservables;

import com.example.singh.android_rxjava2.utils.ObserverFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by singh on 18-Sep-17.
 */

public class Just {

    public static void main(String[] args) {

        //create an observable for method 2
        Observable<String> stringObservable = Observable.just("first", "second", "third", "four");


        //create an observer to print the emissions
        Observer<String> observer = ObserverFactory.getStringObserver();


        //subscribe the observer to the observable
        stringObservable.subscribe(observer);




    }
}
