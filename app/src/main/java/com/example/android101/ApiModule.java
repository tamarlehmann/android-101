package com.example.android101;

/**
 * Created by tamarlehmann on 20/11/2017.
 */

import android.content.Context;

import com.example.android101.constant.AppConstants;
import com.example.android101.gson.AutoValueGsonFactory;
import com.example.android101.service.TwitterAPI;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sverma on 08/06/2017.
 */

@Module
public class ApiModule {

    @Provides
    @Named(AppConstants.Named.NAMED_TOKEN)
    public String provideToken(Context context) {
        return context.getString(R.string.bearer_token);
    }

    @Provides
    @Named(AppConstants.Named.NAMED_BASE_URL)
    public String provideBaseUrl(Context context) {
        return context.getString(R.string.base_url);
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create(
                new GsonBuilder().serializeNulls().registerTypeAdapterFactory(AutoValueGsonFactory.create())
                        .create());
    }

    @Provides @Singleton
    public TwitterAPI provideTwitterAPI(@Named(AppConstants.Named.NAMED_BASE_URL) String baseUrl,
                                        @Named(AppConstants.Named.NAMED_TOKEN) String authToken,
                                        GsonConverterFactory gsonConverterFactory) {
        Retrofit retrofit = getRetrofit(baseUrl, authToken, gsonConverterFactory);
        return retrofit.create(TwitterAPI.class);
    }

    private Retrofit getRetrofit(String baseUrl, String authToken, GsonConverterFactory gsonConverterFactory) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request newRequest  = chain.request().newBuilder()
                    .addHeader("Authorization", authToken)
                    .build();
            return chain.proceed(newRequest);
        });
        if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        OkHttpClient client = builder.build();
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}