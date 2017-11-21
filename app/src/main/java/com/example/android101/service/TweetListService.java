package com.example.android101.service;

import com.example.android101.model.Tweet;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.Call;

/**
 * Created by tamarlehmann on 20/11/2017.
 */

public interface TweetListService {

    Observable<List<Tweet>> getTweets(String listId, int count);
}
