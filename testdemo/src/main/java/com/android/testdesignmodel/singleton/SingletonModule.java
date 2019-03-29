package com.android.testdesignmodel.singleton;

public class SingletonModule {


    private static volatile SingletonModule mSingletonModule;

    private SingletonModule() {
    }

    public static SingletonModule getInstance(){

        if(mSingletonModule == null) {
            synchronized(SingletonModule.class){
                if(mSingletonModule == null) {
                    mSingletonModule = new SingletonModule();
                }
            }
        }
        return mSingletonModule;
    }


}
