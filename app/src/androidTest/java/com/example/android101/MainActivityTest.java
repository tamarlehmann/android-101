package com.example.android101;

import android.app.Application;
import android.support.annotation.VisibleForTesting;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.inject.Singleton;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import dagger.Component;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.*;


/**
 * Created by akramrasikh on 22/11/2017.
 */

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class,
            false, false);

    @Before
    public void setUp() {
        MyApplication application = (MyApplication) InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext()
                .getApplicationContext();

        ApplicationComponent testComponent = DaggerApplicationComponent.builder()
                .apiModule(new TestModule()).build();

        application.setApplicationComponent(testComponent);

        testComponent.
    }

    @Test
    public void tweetListLoadedSuccessfully() {

        InputStream jsonStream = MainActivityTest.class.getClassLoader().getResourceAsStream("twitter_dummy_response.json");

        try {
            byte[] tweetBytes = IOUtils.toByteArray(jsonStream);
            MockResponse mockResponseTweet = new MockResponse().setBody(new String(tweetBytes));

            server.enqueue(mockResponseTweet);

            server.start();


            activityTestRule.launchActivity(null);
            onView(withId(R.id.tweet_list)).check(matches(isDisplayed()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
