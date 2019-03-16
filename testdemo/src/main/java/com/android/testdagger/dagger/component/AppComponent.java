package com.android.testdagger.dagger.component;

import android.app.Application;

import com.android.testdagger.AppApplication;
import com.android.testdagger.dagger.module.AbsApplicationModule;
import com.android.testdagger.dagger.module.ActivityBindingModule;
import com.android.testdagger.dagger.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        AbsApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<AppApplication> {

    Application application();

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }

//    @Component.Builder
//    abstract class Builder extends AndroidInjector.Builder<AppApplication>{}
}
