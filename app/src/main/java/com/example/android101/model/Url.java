package com.example.android101.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sverma on 08/06/2017.
 */

@AutoValue public abstract class Url {
    @SerializedName("url")
    public abstract String url();

    public static TypeAdapter<Url> typeAdapter(Gson gson) {
        return new AutoValue_Url.GsonTypeAdapter(gson);
    }
}
