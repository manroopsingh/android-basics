package com.example.singh.android_mvp.view.personlist;


import com.example.singh.android_mvp.data.local.LocalDataSource;
import com.example.singh.android_mvp.model.Person;

import java.util.List;

/**
 * Author: singh on: 19-Dec-17.
 */

public class PersonListPresenter implements PersonListContract.Presenter {

    PersonListContract.View view;

    @Override
    public void attachView(PersonListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;
    }

    @Override
    public void getPersonList() {

        List<Person> personList;
        personList = LocalDataSource.createPersonList();

        view.sendPersonList(personList);
    }

    @Override
    public void setupRecyclerView() {
        view.setupRecyclerView();
    }
}
