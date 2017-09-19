package com.example.singh.android_rxjava2.CreatingObservables;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by singh on 18-Sep-17.
 */

public class Just {

    public static void main(String[] args) {

        //create an observable for method 2
        Observable<String> stringObservable = Observable.just("first", "second", "third", "four");


        //method 1 to subscribe
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

                System.out.println("onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull String s) {

                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete: ");

            }
        };


        //subscribe the observer to the observable
        stringObservable.subscribe(observer);




    }
}
