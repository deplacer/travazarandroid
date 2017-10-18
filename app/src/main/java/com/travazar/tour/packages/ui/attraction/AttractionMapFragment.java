/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/18/17 2:46 PM
 */

package com.travazar.tour.packages.ui.attraction;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.Attraction;

/**
 * Created by kali_root on 10/18/2017.
 */

public class AttractionMapFragment extends MapFragment implements OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    private LatLngBounds.Builder mLatLngBoundsBuilder;

    private GoogleMap.OnInfoWindowClickListener mInfoWindowClickListener = new GoogleMap.OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {

        }
    };
    private GoogleMap.InfoWindowAdapter mInfoWindowAdapter = new GoogleMap.InfoWindowAdapter() {
        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            return null;
        }
    };

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mLatLngBoundsBuilder = LatLngBounds.builder();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        if (mGoogleMap != null) {
            mGoogleMap.setOnInfoWindowClickListener(mInfoWindowClickListener);
            mGoogleMap.setInfoWindowAdapter(mInfoWindowAdapter);
        }
    }

    public void addItem(Attraction attraction) {
        if (mGoogleMap == null) return;
        LatLng latLng = new LatLng(attraction.latitude(), attraction.longitude());
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title(attraction.name())
                .visible(true);
        mGoogleMap.addMarker(markerOptions);
        mLatLngBoundsBuilder.include(latLng);
        int padding = getResources().getDimensionPixelSize(R.dimen.margin_small);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(mLatLngBoundsBuilder.build(), padding));
    }
}
