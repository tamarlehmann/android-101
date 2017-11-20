package com.example.android101;

import android.app.Application;

/**
 * Created by tamarlehmann on 20/11/2017.
 */

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().applicationModule(
                new ApplicationModule(this)).build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
