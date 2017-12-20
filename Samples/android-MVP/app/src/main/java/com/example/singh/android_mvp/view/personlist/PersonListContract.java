package com.example.singh.android_mvp.view.personlist;

import com.example.singh.android_mvp.model.Person;
import com.example.singh.android_mvp.utils.BasePresenter;
import com.example.singh.android_mvp.utils.BaseView;

import java.util.List;

/**
 * Author: singh on: 19-Dec-17.
 */

public interface PersonListContract {

    interface View extends BaseView{

        void sendPersonList(List<Person> personList);

        void setupRecyclerView();


    }

    interface Presenter extends BasePresenter<View>{

        void getPersonList();

        void setupRecyclerView();
    }
}
