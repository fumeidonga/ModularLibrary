package com.android.testdagger.activitys.one_mvp;

import com.android.modulcommons.mvp.BasePresenter;
import com.android.modulcommons.mvp.BaseView;

public interface OneContract {

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
