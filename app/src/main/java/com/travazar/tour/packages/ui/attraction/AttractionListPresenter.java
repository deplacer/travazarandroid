package com.travazar.tour.packages.ui.attraction;

/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/19/17 5:50 PM
 */

import android.content.Context;

import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.ui.attraction.details.AttractionDetailsActivity;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by kali_root on 10/19/2017.
 */

public class AttractionListPresenter implements AttractionListContract.Presenter {
    private final AttractionListContract.View mAttractionListView;

    public AttractionListPresenter(AttractionListContract.View attractionListView) {
        mAttractionListView = checkNotNull(attractionListView);
        mAttractionListView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void openAttractionDetails(Context context, Attraction attraction) {
        checkNotNull(attraction);
        AttractionDetailsActivity.launch(context, attraction);
    }

    @Override
    public void detectCurrentLocation() {

    }
}
