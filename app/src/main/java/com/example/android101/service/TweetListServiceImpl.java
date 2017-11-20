package com.example.android101.service;


import com.example.android101.model.Tweet;
import com.example.android101.service.TweetListService;

import java.util.List;

import retrofit2.Call;

/**
 * Created by tamarlehmann on 20/11/2017.
 */

public class TweetListServiceImpl implements TweetListService {

    private TwitterAPI twitterAPI;

    public TweetListServiceImpl(TwitterAPI twitterAPI) {
        this.twitterAPI = twitterAPI;
    }

    @Override
    public Call<List<Tweet>> getTweets(String listId, int count) {
        return twitterAPI.getTweets(listId, "extended", 1, count);
    }

}
