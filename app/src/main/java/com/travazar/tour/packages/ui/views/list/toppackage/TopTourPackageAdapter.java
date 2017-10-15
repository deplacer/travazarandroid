package com.travazar.tour.packages.ui.views.list.toppackage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.travazar.tour.packages.GlideApp;
import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.TourPackage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kali_root on 10/12/2017.
 */

public class TopTourPackageAdapter extends RecyclerView.Adapter<TopTourPackageAdapter.TopTourPackageHolder> {
    List<TourPackage> mTourPackages;

    public TopTourPackageAdapter(@NonNull List<TourPackage> tourPackages) {
        mTourPackages = tourPackages;
    }

    @Override
    public TopTourPackageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TopTourPackageHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_top_tour_package, parent, false));
    }

    @Override
    public void onBindViewHolder(TopTourPackageHolder holder, int position) {
        // TODO: 10/12/2017 implement this
        // dummy
        GlideApp.with(holder.itemView)
                .load("http://aws-cdn-01.shemazing.ie/wp-content/uploads/2015/09/tower_2.jpg")
                .error(R.drawable.dummy_image_preview)
                .thumbnail(0.1f)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return mTourPackages.size();
    }

    class TopTourPackageHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_title)
        TextView title;
        @BindView(R.id.image_thumbnail)
        ImageView thumbnail;
        @BindView(R.id.rating_bar)
        RatingBar ratingBar;
        @BindView(R.id.text_rating)
        TextView rating;
        @BindView(R.id.text_total_reviews)
        TextView totalReviews;
        @BindView(R.id.text_short_description)
        TextView shortDescription;
        @BindView(R.id.text_price)
        TextView price;
        @BindView(R.id.button_book)
        Button book;

        public TopTourPackageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
