package com.travazar.tour.packages.ui.views.list.tourpackage;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.travazar.tour.packages.GlideApp;
import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.PriceOption;
import com.travazar.tour.packages.data.model.TourPackage;
import com.travazar.tour.packages.data.model.base.Price;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;
import com.travazar.tour.packages.ui.base.BaseViewHolder;
import com.travazar.tour.packages.util.FormatterUtil;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kali_root on 10/12/2017.
 */

public class TourPackageListAdapter extends BaseRecyclerViewAdapater<TourPackage, TourPackageListAdapter.TopTourPackageHolder> {

    public TourPackageListAdapter(@NonNull List<TourPackage> tourPackages) {
        mDataList = tourPackages;
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
        holder.onItemClickListener = mOnItemClickListener;
        holder.setData(mDataList.get(position));
    }

    class TopTourPackageHolder extends BaseViewHolder<TourPackage> {
        @BindView(R.id.text_package_title)
        TextView title;
        @BindView(R.id.image_package_thumbnail)
        ImageView thumbnail;
        @BindView(R.id.package_rating_bar)
        RatingBar ratingBar;
        @BindView(R.id.text_package_rating)
        TextView rating;
        @BindView(R.id.text_package_total_reviews)
        TextView totalReviews;
        @BindView(R.id.text_package_short_description)
        TextView shortDescription;
        @BindView(R.id.text_package_price)
        TextView price;

        @OnClick(R.id.button_book)
        void onBookClick() {
            Toast.makeText(itemView.getContext(), "Clicked!", Toast.LENGTH_SHORT).show();
        }

        public TopTourPackageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(TourPackage tourPackage) {
            data = tourPackage;
            if (data == null) return;
            title.setText(tourPackage.title());
            rating.setText(FormatterUtil.displayedRating(tourPackage.rating()));
            ratingBar.setRating((float) tourPackage.rating());
            totalReviews.setText(tourPackage.totalReviews());
            shortDescription.setText(tourPackage.shortDescription());
            List<PriceOption> priceOptions = tourPackage.priceOptions();
            if (priceOptions != null && priceOptions.size() > 0) {
                Collections.sort(priceOptions, PriceOption.numberOfPersonComparator());
                Price price = priceOptions.get(0).price();
                this.price.setText(price.currency() + price.displayAmount());
            }
            GlideApp.with(itemView)
                    .load(tourPackage.coverImageUrl())
                    .error(R.drawable.dummy_image_preview)
                    .thumbnail(0.1f)
                    .into(thumbnail);
        }
    }
}
