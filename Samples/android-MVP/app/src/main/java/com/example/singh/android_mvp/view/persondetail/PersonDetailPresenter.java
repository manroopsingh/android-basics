package com.example.singh.android_mvp.view.persondetail;

import com.example.singh.android_mvp.view.personlist.PersonListContract;

/**
 * Created by singh on 12/20/17.
 */

public class PersonDetailPresenter implements PersonDetailContract.Presenter{

    PersonDetailContract.View view;


    @Override
    public void attachView(PersonDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;
    }

    @Override
    public void getPerson() {

        view.onPersonReceived();
    }
}
