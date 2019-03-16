package com.android.testdagger.dagger.module;

import com.android.testdagger.activitys.method_inject.FourActivity;
import com.android.testdagger.activitys.method_inject.module.InjectModule;
import com.android.testdagger.activitys.one_mvp.OneActivity;
import com.android.testdagger.activitys.three_absdagger.ThreeActivity;
import com.android.testdagger.activitys.two_mvp_dagger.TwoActivity;
import com.android.testdagger.activitys.three_absdagger.module.ABSThreeModule;
import com.android.testdagger.activitys.two_mvp_dagger.module.TwoModule;
import com.android.testdagger.dagger.scope.ActivityScoped;
import com.android.testdagger.fragments.TasksActivity;
import com.android.testdagger.fragments.TasksModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract OneActivity oneActivity();

//    @ActivityScoped
    @ContributesAndroidInjector(modules = TwoModule.class)
    abstract TwoActivity twoActivity();

//    @ActivityScoped
    @ContributesAndroidInjector(modules = {ABSThreeModule.class})
    abstract ThreeActivity threeActivity();

//    @ContributesAndroidInjector
    @ActivityScoped
    @ContributesAndroidInjector(modules = {InjectModule.class})
    abstract FourActivity fourActivity();

    @ContributesAndroidInjector(modules = {TasksModule.class})
    abstract TasksActivity tasksActivity();
}
