package com.travazar.tour.packages.ui.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.travazar.tour.packages.GlideApp;
import com.travazar.tour.packages.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Joseph Mangmang on 10/24/2017.
 */

public class AttractionView extends CardView {
    @BindView(R.id.text_attraction_title)
    TextView mTitle;
    @BindView(R.id.image_attraction_thumbnail)
    ImageView mThumbnail;
    @BindView(R.id.text_attraction_address)
    TextView mAddress;
    @BindView(R.id.attraction_rating_bar)
    RatingBar mRatingBar;
    @BindView(R.id.text_attraction_total_reviews)
    TextView mTotalReviews;

    public AttractionView(Context context) {
        super(context);
        init();
    }

    public AttractionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AttractionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_item_attraction_info_window, this);
        ButterKnife.bind(this);
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public void setThumbnail(String thumbnailUrl) {
        GlideApp.with(this)
                .load(thumbnailUrl)
                .thumbnail(0.1f)
                .into(mThumbnail);
    }

    public void setAddress(String address) {
        mAddress.setText(address);
    }

    public void setRating(float rating) {
        mRatingBar.setRating(rating);
    }

    public void setTotalReviews(String totalReviews) {
        mTotalReviews.setText(totalReviews);
    }
}
