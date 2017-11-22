package com.example.android101;

import android.content.Context;

import com.example.android101.constant.AppConstants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Provides;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Created by akramrasikh on 22/11/2017.
 */

public class TestModule extends ApiModule {

    @Override
    @Provides
    @Named(AppConstants.Named.NAMED_BASE_URL)
    public String provideBaseUrl(Context context) {
        return "/";
    }

    @Provides
    @Singleton
    MockWebServer providesMockWebServer() {
        return new MockWebServer();
    }
}
