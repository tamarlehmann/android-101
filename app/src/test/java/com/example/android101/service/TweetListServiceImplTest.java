package com.example.android101.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * Created by akramrasikh on 21/11/2017.
 */

public class TweetListServiceImplTest {

    @Mock
    TwitterAPI twitterAPI;

    @InjectMocks
    TweetListServiceImpl tweetListService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tweetListService = new TweetListServiceImpl(twitterAPI);
    }

    @Test
    public void getTweetsTests() {
        tweetListService.getTweets("1", 1);
        Mockito.verify(twitterAPI, Mockito.times(1))
                .getTweets("1", "extended", 1, 1);
    }
}
