package com.example.android101;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android101.adapter.TweetListAdapter;
import com.example.android101.model.Tweet;
import com.example.android101.presenter.TweetListPresenter;
import com.example.android101.view.TwitterListMVPView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TwitterListMVPView {

    @Inject
    TweetListPresenter tweetListPresenter;

    TweetListAdapter tweetListAdapter;

    @BindView(R.id.tweet_list)
    RecyclerView tweetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getApplication()).getApplicationComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tweetListPresenter.setMVPView(this);

        tweetList.setLayoutManager(new LinearLayoutManager(this));

        tweetListAdapter = new TweetListAdapter();
        tweetList.setAdapter(tweetListAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        tweetListPresenter.getTweetList();
    }


//    Methods from MVPView

    @Override
    public String getListId() {
        return getString(R.string.twitter_list_id);
    }

    @Override
    public int getTweetCount() {
        return 10;
    }

    @Override
    public void onTweetsLoaded(List<Tweet> tweets) {
        Log.d("MainActivity", "Adding tweets " + tweets.size());
        tweetListAdapter.addTweets(tweets);
    }

    @Override
    public void onTweetsLoadError(Throwable throwable) {
        Log.i("MainActivity", throwable.getMessage());

    }

    @Override
    public void onTweetsLoadComplete() {

    }
}
