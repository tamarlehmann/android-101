package com.example.android101.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sverma on 08/06/2017.
 */

@AutoValue public abstract class RetweetedStatus {
    @SerializedName("created_at")
    public abstract String createdAt();

    @SerializedName("full_text")
    public abstract String fullText();

    @SerializedName("truncated")
    public abstract boolean truncated();

    @SerializedName("entities")
    public abstract Entities entities();

    public static TypeAdapter<RetweetedStatus> typeAdapter(Gson gson) {
        return new AutoValue_RetweetedStatus.GsonTypeAdapter(gson);
    }
}
