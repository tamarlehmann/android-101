package com.example.android101.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sverma on 08/06/2017.
 */

@AutoValue public abstract class Sizes {
    @SerializedName("small")
    public abstract Size small();

    @SerializedName("medium")
    public abstract Size medium();

    @SerializedName("large")
    public abstract Size large();

    @SerializedName("thumb")
    public abstract Size thumb();

    public static TypeAdapter<Sizes> typeAdapter(Gson gson) {
        return new AutoValue_Sizes.GsonTypeAdapter(gson);
    }
}
