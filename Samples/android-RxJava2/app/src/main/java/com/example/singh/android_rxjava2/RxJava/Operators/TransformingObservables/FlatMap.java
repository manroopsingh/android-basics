package com.example.singh.android_rxjava2.RxJava.Operators.TransformingObservables;

import com.example.singh.android_rxjava2.utils.DataSource;
import com.example.singh.android_rxjava2.utils.ObserverFactory;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by singh on 23-Sep-17.
 */

public class FlatMap {

    public static void main(String[] args) {

        Observable<List<Integer>> integerObservable = Observable.just(DataSource.getIntList(5));

        Observer<Integer> integerObserver = ObserverFactory.getIntObserver();

        //Flatmap transforms the items emitted by the observable into observables
        //then flattens there emission into one a single observable
        integerObservable.flatMap(new Function<List<Integer>, Observable<Integer>>() {
            @Override
            public Observable<Integer> apply(@NonNull List<Integer> integers) throws Exception {

                return Observable.fromIterable(integers);

            }
        }).subscribe(integerObserver);

    }
}
