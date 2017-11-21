package com.example.android101.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android101.model.Entities;
import com.example.android101.model.QuotedStatus;
import com.example.android101.model.RetweetedStatus;
import com.example.android101.model.Tweet;
import com.example.android101.model.User;
import com.example.android101.rxjava.ObservableConfigurer;
import com.example.android101.service.TweetListService;
import com.example.android101.view.TwitterListMVPView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import io.reactivex.Observer;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by akramrasikh on 21/11/2017.
 */

public class TweetListPresenterImplTest {

    @Mock
    TweetListService tweetListService;

    @Mock
    ObservableConfigurer observableConfigurer;

    @InjectMocks
    TweetListPresenterImpl tweetListPresenter;

    @Mock
    TwitterListMVPView twitterListMVPView;

    Observable<List<Tweet>> testObservable;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tweetListPresenter = new TweetListPresenterImpl(tweetListService, observableConfigurer);
        testObservable = getTestObservable();

    }

    @After
    public void tearDown(){
        verifyNoMoreInteractions(tweetListService, observableConfigurer, twitterListMVPView);
    }

    @NonNull
    private Observable<List<Tweet>> getTestObservable() {
        return new Observable<List<Tweet>>() {
            @Override
            protected void subscribeActual(Observer<? super List<Tweet>> observer) {

            }
        };
    }

    @Test
    public void getTweetList_returnsNullWhenViewNullTest(){

        tweetListPresenter.getTweetList();

    }

    @Test
    public void getTweetList_callsThreeGetsMethodsTests() {
        Mockito.doReturn("Hello").when(twitterListMVPView).getListId();
        Mockito.doReturn(1).when(twitterListMVPView).getTweetCount();

        Mockito.doReturn(testObservable).when(tweetListService).getTweets("Hello", 1);
        Mockito.doReturn(testObservable).when(observableConfigurer).configureObservable(isA(Observable.class));


        tweetListPresenter.setMVPView(twitterListMVPView);
        tweetListPresenter.getTweetList();


        Mockito.verify(tweetListService).getTweets("Hello", 1);
        Mockito.verify(observableConfigurer).configureObservable(testObservable);
        Mockito.verify(twitterListMVPView).getTweetCount();
        Mockito.verify(twitterListMVPView).getListId();

    }

    @Test(expected = NullPointerException.class)
    public void getTweetList_Observer_OnNext_MVPViewNotSet() {
        Observer<List<Tweet>> observer = tweetListPresenter.getTweetListObserver();

        observer.onNext(getTweets());
    }

    @Test
    public void getTweetList_Observer_OnNext_MVPViewSet() {
        tweetListPresenter.setMVPView(twitterListMVPView);
        Observer<List<Tweet>> observer = tweetListPresenter.getTweetListObserver();

        List<Tweet> tweets = getTweets();
        observer.onNext(tweets);
        verify(twitterListMVPView).onTweetsLoaded(tweets);

    }

    @Test
    public void getTweetList_Observer_OnError_ThrowsError() {
        tweetListPresenter.setMVPView(twitterListMVPView);
        Observer<List<Tweet>> observer = tweetListPresenter.getTweetListObserver();

        Throwable throwable = new Throwable("ERROR!!");
        observer.onError(throwable);
        verify(twitterListMVPView).onTweetsLoadError(throwable);
    }

    @Test
    public void getTweetList_Observer_OnComplete_MVPViewSet() {
        tweetListPresenter.setMVPView(twitterListMVPView);
        Observer<List<Tweet>> observer = tweetListPresenter.getTweetListObserver();

        observer.onComplete();
        verify(twitterListMVPView).onTweetsLoadComplete();
    }

    private List<Tweet> getTweets() {
        ArrayList<Tweet> tweets = new ArrayList<>();
        Tweet tweet = new Tweet() {
            @Override
            public String body() {
                return "Test Body";
            }

            @Override
            public String createdAt() {
                return "10/10/2017";
            }

            @Override
            public long id() {
                return 0;
            }

            @Override
            public User user() {
                return null;
            }

            @Nullable
            @Override
            public RetweetedStatus retweetedStatus() {
                return null;
            }

            @Nullable
            @Override
            public QuotedStatus quotedStatus() {
                return null;
            }

            @Override
            public Entities entities() {
                return null;
            }
        };
        tweets.add(tweet);
        return tweets;
    }


}
