/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/16/17 7:44 PM
 */

package com.travazar.tour.packages.ui.attraction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.travazar.tour.packages.GlideApp;
import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.dummy.Dummy;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;
import com.travazar.tour.packages.ui.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kali_root on 10/16/2017.
 */

public class AttractionAdapter extends BaseRecyclerViewAdapater<Attraction, AttractionAdapter.AttractionHolder> {

    public AttractionAdapter() {
        // TODO: 10/17/2017 remove dummy attraction
        mDataList = Dummy.getTopAttractions();
    }

    @Override
    public AttractionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AttractionHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_attraction, parent, false));
    }

    @Override
    public void onBindViewHolder(AttractionHolder holder, int position) {
        Attraction attraction = mDataList.get(position);
        holder.data = attraction;
        holder.onItemClickListener = mOnItemClickListener;
        holder.title.setText(attraction.name());
        holder.address.setText(attraction.getAddress());
        holder.ratingBar.setRating((float) attraction.rating());
        holder.totalReviews.setText(attraction.totalReviews());
        GlideApp.with(holder.itemView)
                .load(attraction.imageUrl())
                .centerCrop()
                .thumbnail(0.1f)
                .into(holder.thumbnail);
    }

    class AttractionHolder extends BaseViewHolder<Attraction> {
        @BindView(R.id.text_attraction_title)
        TextView title;
        @BindView(R.id.image_attraction_thumbnail)
        ImageView thumbnail;
        @BindView(R.id.text_attraction_address)
        TextView address;
        @BindView(R.id.attraction_rating_bar)
        RatingBar ratingBar;
        @BindView(R.id.text_attraction_total_reviews)
        TextView totalReviews;

        public AttractionHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
