package com.example.android101.model;

import android.net.Uri;

/**
 * Created by tamarlehmann on 21/11/2017.
 */

public class ImageUri {

    private Uri uri;

    private int width;

    private int height;

    public ImageUri(Uri uri, int width, int height) {
        this.uri = uri;
        this.width = width;
        this.height = height;
    }


    public Uri getUri() {
        return uri;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
