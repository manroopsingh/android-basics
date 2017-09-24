package com.example.singh.android_rxjava2.RxJava.Operators.FIlteringObservables;

import com.example.singh.android_rxjava2.utils.ObserverFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;

/**
 * Created by singh on 23-Sep-17.
 */

public class Filter {

    public static void main(String[] args) {


        Observable<String> stringObservable = Observable.just("first", "second");

        Observer<String> stringObserver = ObserverFactory.getStringObserver();

        //filter will remove the emissions that does not pass the test
        stringObservable.filter(new Predicate<String>() {
            @Override
            public boolean test(@NonNull String s) throws Exception {
                if (s.equals("first"))
                    return true;
                else
                    return false;

            }
        }).subscribe(stringObserver);

    }


}
