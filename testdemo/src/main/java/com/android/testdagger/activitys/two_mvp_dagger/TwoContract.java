package com.android.testdagger.activitys.two_mvp_dagger;

import com.android.modulcommons.mvp.BasePresenter;
import com.android.modulcommons.mvp.BaseView;

public interface TwoContract {

    interface View extends BaseView<Presenter> {

        void editTask();

        void deleteTask();

        void completeTask();

    }

    interface Presenter extends BasePresenter<View> {

        void editTask();

        void deleteTask();

        void completeTask();
    }
}
