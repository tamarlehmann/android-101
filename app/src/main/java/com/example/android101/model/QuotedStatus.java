package com.example.android101.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tamarlehmann on 21/11/2017.
 */

@AutoValue
public abstract class QuotedStatus {
    @SerializedName("created_at")
    public abstract String createdAt();

    @SerializedName("full_text")
    public abstract String fullText();

    @SerializedName("truncated")
    public abstract boolean truncated();

    @SerializedName("entities")
    public abstract Entities entities();

    public static TypeAdapter<QuotedStatus> typeAdapter(Gson gson) {
        return new AutoValue_QuotedStatus.GsonTypeAdapter(gson);
    }
}