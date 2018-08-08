package com.example.user.architecturecomponents.model;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.example.user.architecturecomponents.PersonViewModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class PersonDataSource {

    private static final String TAG = PersonDataSource.class.getSimpleName();

    private PersonViewModel personViewModel;
    private PersonDatabase personDatabase;
    private PersonDao personDao;

    public static Person getPerson() {
        return new Person("John Doe", "23", "Male");

    }

    public PersonDataSource(Context context, PersonViewModel personViewModel) {
        this.personViewModel = personViewModel;
        personDatabase =
                Room.databaseBuilder(
                        context,
                        PersonDatabase.class,
                        "person-database").build();

        personDao = personDatabase.personDao();

    }

    public void insert(final Person person) {

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                personDao.updatePerson(person);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        personViewModel.updateViewModel(person);
                        Log.d(TAG, "onComplete: ");

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });


    }

    public void getAllPerson() {

    }


    interface OnResults {

        void onPerson(Person person);

        void onPersonList(List<Person> personList);
    }
}
