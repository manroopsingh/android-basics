package com.example.singh.android_rxjava2.TransformingObservables;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by singh on 18-Sep-17.
 */

public class Map {

    public static void main(String[] args) {

        Observable<Integer> integerObservable = Observable.range(1, 10);

        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

                System.out.println("onSubscribe:");
            }

            @Override
            public void onNext(@NonNull Integer integer) {

                System.out.println("onNext: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

                System.out.println("onComplete: ");
            }
        };

        //map would transform each emitted object by the observable
        integerObservable.map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer integer) throws Exception {
                integer = integer * 10;
                return integer;

            }
        }).subscribe(integerObserver);


    }
}
