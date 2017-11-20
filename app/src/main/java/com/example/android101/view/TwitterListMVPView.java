package com.example.android101.view;

import com.example.android101.model.Tweet;

import java.util.List;

/**
 * Created by tamarlehmann on 20/11/2017.
 */

public interface TwitterListMVPView {

    String getListId();

    int getTweetCount();

    void onTweetsLoaded(List<Tweet> tweets);

    void onTweetsLoadError(Throwable throwable);

    void onTweetsLoadComplete();

}
