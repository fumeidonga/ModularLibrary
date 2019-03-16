package com.android.testdagger.activitys.method_inject.module;

import com.android.testdagger.activitys.method_inject.itest.ITest;
import com.android.testdagger.activitys.method_inject.itest.Test;
import com.android.testdagger.dagger.scope.ActivityScoped;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class InjectModule {

    /**
     * DoubleCheck 包装的意义在于持有了 T 的实例
     *  使用@ActivityScoped后，每次注入依赖都只会返回第一次生成的实例
     *
     *     @SuppressWarnings("unchecked")
     *     private void initialize(final FourActivitySubcomponentBuilder builder) {
     *       this.provideITestProvider = DoubleCheck.provider((Provider) Test_Factory.create());
     *     }
     * @param test
     * @return
     */
    @Binds
    @ActivityScoped
    abstract ITest provideITest(Test test);
}
