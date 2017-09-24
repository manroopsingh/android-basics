package com.example.singh.android_rxjava2.RxJava.Operators.TransformingObservables;

import com.example.singh.android_rxjava2.utils.ObserverFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by singh on 18-Sep-17.
 */

public class Map {

    public static void main(String[] args) {

        //creating an observable to emit integer from 1 to 10
        final Observable<Integer> integerObservable = Observable.range(1, 10);

        //create an observer that will receive the emitted values from the observer
        final Observer<Integer> integerObserver = ObserverFactory.getIntObserver();

        //map would transform each emitted object by the observable
        integerObservable
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer) throws Exception {
                        integer = integer * 10;
                        return integer;

                    }
                })
                .subscribe(integerObserver);




    }
}
