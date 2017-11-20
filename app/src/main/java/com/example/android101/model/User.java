package com.example.android101.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sverma on 08/06/2017.
 */

@AutoValue public abstract class User {
    @SerializedName("name")
    public abstract String name();

    @SerializedName("screen_name")
    public abstract String screenName();

    @SerializedName("location")
    public abstract String location();

    @SerializedName("description")
    public abstract String description();

    public static TypeAdapter<User> typeAdapter(Gson gson) {
        return new AutoValue_User.GsonTypeAdapter(gson);
    }
}
