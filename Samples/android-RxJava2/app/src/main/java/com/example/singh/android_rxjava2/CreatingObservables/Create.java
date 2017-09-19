package com.example.singh.android_rxjava2.CreatingObservables;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by singh on 18-Sep-17.
 */

public class Create {

    public static void main(String[] args) {

        final List<String> someDataStrings = getSomeList();

        //Creating an observable from scratch
        Observable<String> stringObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {

                System.out.println("onSubscribe" + someDataStrings.size());

                for(String s: someDataStrings){
                    e.onNext(s);
                }
                e.onComplete();
            }
        });


        //subscribe a DisposableObserver
        DisposableObserver<String> disposableObserver = stringObservable.subscribeWith(new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                System.out.println("onNext: " +s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");

            }
        });

        disposableObserver.dispose();

    }

    private static List<String> getSomeList() {
        List<String> someDataStrings = new ArrayList<>();
        someDataStrings.add("first");
        someDataStrings.add("second");
        someDataStrings.add("third");
        someDataStrings.add("fourth");
        return someDataStrings;
    }
}
