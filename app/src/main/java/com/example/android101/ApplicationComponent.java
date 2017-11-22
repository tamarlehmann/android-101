package com.example.android101;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by tamarlehmann on 20/11/2017.
 */
@Singleton
@Component(modules = {TwitterModule.class, ApplicationModule.class, ApiModule.class, RxModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);

}
