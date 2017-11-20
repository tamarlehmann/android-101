package com.example.android101.presenter;

import com.example.android101.view.TwitterListMVPView;

/**
 * Created by tamarlehmann on 20/11/2017.
 */

public interface TweetListPresenter {

    void getTweetList();

    void setMVPView(TwitterListMVPView mvpView);

}