package com.example.android101;

import com.example.android101.presenter.TweetListPresenter;
import com.example.android101.presenter.TweetListPresenterImpl;
import com.example.android101.service.TweetListService;
import com.example.android101.service.TweetListServiceImpl;
import com.example.android101.service.TwitterAPI;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamarlehmann on 20/11/2017.
 */

@Module
public class TwitterModule {

    @Provides
    public TweetListService providesTweetListService(TwitterAPI twitterAPI) {
        return new TweetListServiceImpl(twitterAPI);
    }

    @Provides
    public TweetListPresenter providesTweetListPresenter(TweetListService tweetListService) {
        return new TweetListPresenterImpl(tweetListService);
    }
}
