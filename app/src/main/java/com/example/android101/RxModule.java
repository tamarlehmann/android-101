package com.example.android101;

import com.example.android101.rxjava.AndroidObservableConfigurer;
import com.example.android101.rxjava.ObservableConfigurer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by tamarlehmann on 21/11/2017.
 */

@Module
public class RxModule {

    @Provides @Singleton
    public ObservableConfigurer provideObservableConfigurer() {
        return new AndroidObservableConfigurer();
    }

}