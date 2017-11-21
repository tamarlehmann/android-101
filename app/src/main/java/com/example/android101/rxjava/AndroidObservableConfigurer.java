package com.example.android101.rxjava;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by tamarlehmann on 21/11/2017.
 */

public class AndroidObservableConfigurer implements ObservableConfigurer {

    @Override
    public <T>Observable<T> configureObservable(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}



