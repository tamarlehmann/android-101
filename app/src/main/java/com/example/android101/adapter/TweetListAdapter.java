package com.example.android101.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android101.GlideApp;
import com.example.android101.R;
import com.example.android101.model.ImageUri;
import com.example.android101.model.Tweet;

import org.w3c.dom.Text;

import com.bumptech.glide.*;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tamarlehmann on 20/11/2017.
 */

public class TweetListAdapter extends RecyclerView.Adapter<TweetListAdapter.TweetViewHolder> {

    private List<Tweet> tweetList;
    private Activity activity;

    public TweetListAdapter(Activity activity) {
        this.activity = activity;
        this.tweetList = new ArrayList<>();
    }

    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.tweet_card, viewGroup, false);
        TweetViewHolder tweetViewHolder = new TweetViewHolder(view);
        tweetViewHolder.setData(tweetList.get(viewType), activity);
        return tweetViewHolder;
    }

    @Override
    public void onBindViewHolder(TweetViewHolder holder, int position) {
        holder.setData(tweetList.get(position), activity);
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public void addTweets(List<Tweet> tweets) {
        tweetList.addAll(tweetList.size(), tweets);

        notifyItemRangeChanged(tweetList.size() - tweets.size(), tweets.size());
    }

    public static class TweetViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tweet_content)
        TextView tweetContent;

        @BindView(R.id.date)
        TextView tweetDate;

        @BindView(R.id.tweet_image)
        ImageView tweetImage;

        public TweetViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(Tweet data, Activity activity) {
            tweetContent.setText(data.body());
            tweetDate.setText(data.createdAt());
            ImageUri imageUri = data.getImageUri();
            if (imageUri != null) {
                Uri uri = imageUri.getUri();
                GlideApp.with(activity).load(uri).into(tweetImage);
            }
        }
    }
}
