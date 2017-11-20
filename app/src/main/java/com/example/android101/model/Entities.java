package com.example.android101.model;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sverma on 08/06/2017.
 */

@AutoValue
public abstract class Entities {

    @Nullable
    @SerializedName("media")
    public abstract List<Media> media();

    @SerializedName("urls")
    public abstract List<Url> url();

    public static TypeAdapter<Entities> typeAdapter(Gson gson) {
        return new AutoValue_Entities.GsonTypeAdapter(gson);
    }
}

