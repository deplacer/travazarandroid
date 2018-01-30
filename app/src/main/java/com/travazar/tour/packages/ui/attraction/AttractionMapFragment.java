/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/18/17 2:46 PM
 */

package com.travazar.tour.packages.ui.attraction;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.travazar.tour.packages.GlideApp;
import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.ui.attraction.details.AttractionDetailsActivity;
import com.travazar.tour.packages.ui.base.BaseFragment;
import com.travazar.tour.packages.ui.views.AttractionView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kali_root on 10/18/2017.
 */

public class AttractionMapFragment extends BaseFragment implements OnMapReadyCallback, AttractionMapContract.View {

    public static final String TAG = AttractionMapFragment.class.getSimpleName();
    private GoogleMap mGoogleMap;
    private LatLngBounds.Builder mLatLngBoundsBuilder;
    private Map<Marker, Attraction> mMarkers = new HashMap<>();
    private AttractionListContract.Presenter mPresenter;
    private AttractionView mAttractionView;
    private MapFragment mMapFragment;
    private Attraction mSelectedAttraction;

    private GoogleMap.OnMarkerClickListener mMarkerClickListener = new GoogleMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
            mSelectedAttraction = mMarkers.get(marker);
            mAttractionView.setTitle(mSelectedAttraction.name());
            mAttractionView.setRating((float) mSelectedAttraction.rating());
            mAttractionView.setAddress(mSelectedAttraction.getAddress());
            mAttractionView.setThumbnail(mSelectedAttraction.imageUrl());
            mAttractionView.setTotalReviews(mSelectedAttraction.totalReviews());
            mAttractionView.setVisibility(View.VISIBLE);
            return false;
        }
    };
    private View.OnClickListener mAttractionViewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AttractionDetailsActivity.launch(mContext, mSelectedAttraction);
        }
    };

    public static AttractionMapFragment newInstance() {
        return new AttractionMapFragment();
    }


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mLatLngBoundsBuilder = LatLngBounds.builder();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_attraction_map, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapFragment = MapFragment.newInstance();
        mAttractionView = (AttractionView) view.findViewById(R.id.attraction_view_info_window);
        mAttractionView.setOnClickListener(mAttractionViewClickListener);
        getFragmentManager().beginTransaction()
                .add(R.id.map_fragment, mMapFragment)
                .commit();
        if (mMapFragment == null) {
            return;
        }
        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        if (mGoogleMap != null) {
            mGoogleMap.setOnMarkerClickListener(mMarkerClickListener);
            List<Attraction> attractions = mPresenter != null ? mPresenter.getLoadedAttractions() : new ArrayList<Attraction>();
            for (Attraction attraction : attractions) {
                addItem(attraction);
            }
        }
    }

    public void addItem(Attraction attraction) {
        if (mGoogleMap == null) return;
        LatLng latLng = new LatLng(attraction.latitude(), attraction.longitude());
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .visible(false)
                .anchor(0.5f, 1);
        final Marker marker = mGoogleMap.addMarker(markerOptions);
        mLatLngBoundsBuilder.include(latLng);
        int padding = getResources().getDimensionPixelSize(R.dimen.margin_small);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(mLatLngBoundsBuilder.build(), padding));
        mMarkers.put(marker, attraction);
        GlideApp.with(this)
                .asBitmap()
                .load(attraction.imageUrl())
                .override(300, 290)
                .fitCenter()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        marker.setIcon(BitmapDescriptorFactory.fromBitmap(toMarkerIcon(resource)));
                        marker.setVisible(true);
                    }
                });
    }

    @Override
    public void setPresenter(AttractionListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    private Bitmap toMarkerIcon(Bitmap source) {
        float outerMargin = 30;
        float margin = 5;
        int thumbnailWidth = source.getWidth();
        int thumbnailHeight = source.getHeight();

        Bitmap output = Bitmap.createBitmap(thumbnailWidth, thumbnailHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        Paint paintBoarder = new Paint();
        paintBoarder.setColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        paintBoarder.setStrokeWidth(margin);
        RectF rectF = new RectF(outerMargin, outerMargin, thumbnailWidth - outerMargin, thumbnailHeight - outerMargin);
        canvas.drawRoundRect(rectF, 5, 5, paintBoarder);

        Paint trianglePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        trianglePaint.setStrokeWidth(2);
        trianglePaint.setColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        trianglePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        trianglePaint.setAntiAlias(true);

        Path triangle = new Path();
        triangle.setFillType(Path.FillType.EVEN_ODD);
        triangle.moveTo(outerMargin, thumbnailHeight / 2);
        triangle.lineTo(thumbnailWidth / 2, thumbnailHeight);
        triangle.lineTo(thumbnailWidth - outerMargin, thumbnailHeight / 2);
        triangle.close();

        canvas.drawPath(triangle, trianglePaint);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(margin + outerMargin,
                margin + outerMargin,
                thumbnailWidth - (margin + outerMargin),
                thumbnailHeight - (margin + outerMargin)), 0, 0, paint);

        return output;
    }
}
