package com.example.singh.android_mvp.view.persondetail;

import com.example.singh.android_mvp.utils.BasePresenter;
import com.example.singh.android_mvp.utils.BaseView;

/**
 * Created by singh on 12/20/17.
 */

public interface PersonDetailContract {

    interface View extends BaseView{

        void onPersonReceived();

    }

    interface Presenter extends BasePresenter<View> {

        void getPerson();

    }

}
