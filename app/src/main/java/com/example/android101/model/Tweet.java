package com.example.android101.model;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sverma on 08/06/2017.
 */

@AutoValue
public abstract class Tweet {
    @SerializedName("full_text")
    public abstract String body();

    @SerializedName("created_at")
    public abstract String createdAt();

    @SerializedName("id")
    public abstract long id();

    @SerializedName("user")
    public abstract User user();

    @Nullable
    @SerializedName("retweeted_status")
    public abstract RetweetedStatus retweetedStatus();

    @SerializedName("entities")
    public abstract Entities entities();

    public static TypeAdapter<Tweet> typeAdapter(Gson gson) {
        return new AutoValue_Tweet.GsonTypeAdapter(gson);
    }

    /*public String getMediaUrl() {
        if(retweetedStatus()!=null && retweetedStatus().entities() != null && retweetedStatus().entities().media()!=null) {
            return retweetedStatus()
        }
    }*/
}


