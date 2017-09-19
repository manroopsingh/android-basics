package com.example.singh.android_rxjava2.CreatingObservables;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by singh on 18-Sep-17.
 */

public class Range {

    public static void main(String[] args) {

        //range will create the observable which emits value from "start" to "count"
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

                System.out.println("onError: " + e.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete: ");

            }
        };


        integerObservable.subscribe(integerObserver);
    }
}
