package com.android.testdagger.activitys.two_mvp_dagger.module;

import com.android.testdagger.activitys.two_mvp_dagger.TwoPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class TwoModule {

    @Provides
    TwoPresenter provideTwoPresenter(){
        return new TwoPresenter();
    }

}
