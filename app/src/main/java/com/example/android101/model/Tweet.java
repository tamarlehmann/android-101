package com.example.android101.model;

import android.net.Uri;
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

    @Nullable
    @SerializedName("quoted_status")
    public abstract QuotedStatus quotedStatus();

    @SerializedName("entities")
    public abstract Entities entities();

    public static TypeAdapter<Tweet> typeAdapter(Gson gson) {
        return new AutoValue_Tweet.GsonTypeAdapter(gson);
    }

    public ImageUri getImageUri() {
        Uri uri;
        if(retweetedStatus()!=null && retweetedStatus().entities() != null &&
                retweetedStatus().entities().media()!=null && retweetedStatus().entities().media().size() > 0) {
            Media media = retweetedStatus().entities().media().get(0);
            uri = Uri.parse(media.mediaUrl());
            return new ImageUri(uri, media.sizes().small().width(), media.sizes().small().height());
        } if(quotedStatus()!=null && quotedStatus().entities() != null &&
                quotedStatus().entities().media()!=null && quotedStatus().entities().media().size() > 0) {
            Media media = quotedStatus().entities().media().get(0);
            uri = Uri.parse(media.mediaUrl());
            return new ImageUri(uri, media.sizes().small().width(), media.sizes().small().height());
        } else if(entities() != null && entities().media()!= null && entities().media().size() > 0) {
            Media media = entities().media().get(0);
            uri = Uri.parse(media.mediaUrl());
            return new ImageUri(uri, media.sizes().small().width(), media.sizes().small().height());
        }
        return null;
    }

    /*public String getMediaUrl() {
        if(retweetedStatus()!=null && retweetedStatus().entities() != null && retweetedStatus().entities().media()!=null) {
            return retweetedStatus()
        }
    }*/
}


