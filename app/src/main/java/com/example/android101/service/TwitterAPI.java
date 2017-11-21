package com.example.android101.service;

/**
 * Created by tamarlehmann on 20/11/2017.
 */

import com.example.android101.model.Tweet;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sverma on 09/06/2017.
 */

public interface TwitterAPI {

    @GET("1.1/lists/statuses.json")
    Observable<List<Tweet>> getTweets(@Query("list_id") String listId, @Query("tweet_mode") String tweet_mode,
                                @Query("include_entities") int includeEntities, @Query("count") int count);

}