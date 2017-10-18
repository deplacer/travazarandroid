/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/18/17 5:07 PM
 */

package com.travazar.tour.packages.ui.attraction.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RatingBar;
import android.widget.TextView;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.ui.base.BaseActivity;
import com.travazar.tour.packages.ui.views.InfoView;
import com.travazar.tour.packages.ui.views.imageslider.ImageSlider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kali_root on 10/18/2017.
 */

public class AttractionDetailsActivity extends BaseActivity {
    @BindView(R.id.image_slider)
    ImageSlider mImageSlider;
    @BindView(R.id.text_title)
    TextView mTitle;
    @BindView(R.id.rating_bar)
    RatingBar mRatingBar;
    @BindView(R.id.text_total_reviews)
    TextView mTotalReview;
    @BindView(R.id.text_address)
    TextView mAddress;
    @BindView(R.id.info_overview)
    InfoView mOverview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_details);
        ButterKnife.bind(this);
    }
}
