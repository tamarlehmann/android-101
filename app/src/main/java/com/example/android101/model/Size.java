package com.example.android101.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sverma on 08/06/2017.
 */

@AutoValue public abstract class Size {
    @SerializedName("w")
    public abstract int width();

    @SerializedName("h")
    public abstract int height();

    @SerializedName("resize")
    public abstract String resize();

    public static TypeAdapter<Size> typeAdapter(Gson gson) {
        return new AutoValue_Size.GsonTypeAdapter(gson);
    }
}
