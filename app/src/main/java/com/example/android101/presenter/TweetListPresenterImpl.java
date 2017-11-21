package com.example.android101.presenter;

import com.example.android101.model.Tweet;
import com.example.android101.rxjava.ObservableConfigurer;
import com.example.android101.service.TweetListService;
import com.example.android101.view.TwitterListMVPView;

import java.util.List;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.observers.DefaultObserver;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tamarlehmann on 20/11/2017.
 */

public class TweetListPresenterImpl implements TweetListPresenter {
    private TweetListService tweetListService;
    private ObservableConfigurer observableConfigurer;

    private TwitterListMVPView twitterListMVPView;

    public TweetListPresenterImpl(TweetListService tweetListService, ObservableConfigurer observableConfigurer) {
        this.tweetListService = tweetListService;
        this.observableConfigurer = observableConfigurer;
    }

    public void setMVPView(TwitterListMVPView twitterListMVPView) {
        this.twitterListMVPView = twitterListMVPView;

    }


    @Override
    public void getTweetList() {
        if (twitterListMVPView == null) {
            return;
        }
        Observable<List<Tweet>> tweetListObs = tweetListService.getTweets(
                twitterListMVPView.getListId(), twitterListMVPView.getTweetCount());
        observableConfigurer.configureObservable(tweetListObs).subscribe(getTweetListObserver());
        }

    private Observer<List<Tweet>> getTweetListObserver() {
        DefaultObserver observer = new DefaultObserver() {
            @Override
            public void onNext(Object value) {
                twitterListMVPView.onTweetsLoaded((List<Tweet>) value);
            }

            @Override
            public void onError(Throwable e) {
                twitterListMVPView.onTweetsLoadError(e);
            }

            @Override
            public void onComplete() {

            }
        };
        return observer;
    }


//        tweetListObs.enqueue(new Callback<List<Tweet>>() {
//            @Override
//            public void onResponse(Call<List<Tweet>>  call, Response<List<Tweet>> response) {
//                twitterListMVPView.onTweetsLoaded(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Tweet>> call, Throwable t) {
//                twitterListMVPView.onTweetsLoadError(t);
//            }
//        });
//    }


}
