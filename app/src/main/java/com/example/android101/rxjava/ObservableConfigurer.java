package com.example.android101.rxjava;

import io.reactivex.Observable;

/**
 * Created by tamarlehmann on 21/11/2017.
 */

public interface ObservableConfigurer {
    <T>Observable<T> configureObservable(Observable<T> observable);
}
