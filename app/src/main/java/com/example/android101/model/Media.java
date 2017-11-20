package com.example.android101.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sverma on 08/06/2017.
 */

@AutoValue public abstract class Media {
    @SerializedName("media_url")
    public abstract String mediaUrl();

    @SerializedName("url")
    public abstract String sourceUrl();

    @SerializedName("type")
    public abstract String type();

    @SerializedName("sizes")
    public abstract Sizes sizes();

    public static TypeAdapter<Media> typeAdapter(Gson gson) {
        return new AutoValue_Media.GsonTypeAdapter(gson);
    }
}
