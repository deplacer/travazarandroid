package com.travazar.tour.packages.ui.attraction;

/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/19/17 5:50 PM
 */

import android.content.Context;
import android.view.View;

import com.google.android.gms.maps.model.Marker;
import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.dummy.Dummy;
import com.travazar.tour.packages.ui.attraction.details.AttractionDetailsActivity;
import com.travazar.tour.packages.ui.views.AttractionView;

import java.util.List;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by kali_root on 10/19/2017.
 */

public class AttractionListPresenter implements AttractionListContract.Presenter {
    private final AttractionListContract.View mAttractionListView;
    private final AttractionMapContract.View mAttractionMapView;

    public AttractionListPresenter(AttractionListContract.View attractionListView, AttractionMapContract.View attractionMapView) {
        mAttractionListView = checkNotNull(attractionListView);
        mAttractionMapView = attractionMapView;
        mAttractionListView.setPresenter(this);
        mAttractionMapView.setPresenter(this);
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

    @Override
    public View createMarkerInfoContent(Context context, Marker marker, Attraction attraction) {
        checkNotNull(attraction);
        AttractionView attractionView = new AttractionView(context);
        attractionView.setTitle(attraction.name());
        attractionView.setRating((float) attraction.rating());
        attractionView.setAddress(attraction.getAddress());
        attractionView.setTotalReviews(attraction.totalReviews());
        return attractionView;
    }

    @Override
    public void requestAttractions(int offset) {
        mAttractionListView.showAttractions(Dummy.getTopAttractions(), offset == 0);
    }

    @Override
    public List<Attraction> getLoadedAttractions() {
        return mAttractionListView.getLoadedAttractions();
    }
}
