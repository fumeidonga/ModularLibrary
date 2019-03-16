package com.android.testdagger.fragments;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 */
@Module
public abstract class TasksModule {
    @ContributesAndroidInjector
    abstract TasksFragment tasksFragment();

}
