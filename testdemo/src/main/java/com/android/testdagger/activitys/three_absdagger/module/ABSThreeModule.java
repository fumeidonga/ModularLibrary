package com.android.testdagger.activitys.three_absdagger.module;

import com.android.testdagger.activitys.three_absdagger.ThreeContract;
import com.android.testdagger.activitys.three_absdagger.ThreePresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ABSThreeModule {

//    @ActivityScoped
    @Binds
    abstract ThreeContract.Presenter twoPresenter(ThreePresenter presenter);

}
