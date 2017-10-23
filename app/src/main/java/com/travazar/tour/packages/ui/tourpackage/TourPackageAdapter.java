package com.travazar.tour.packages.ui.tourpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.util.Preconditions;
import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.PriceOption;
import com.travazar.tour.packages.data.model.TourPackage;
import com.travazar.tour.packages.dummy.Dummy;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;
import com.travazar.tour.packages.ui.base.BaseViewHolder;
import com.travazar.tour.packages.ui.views.imageslider.ImageSlider;
import com.travazar.tour.packages.util.FormatterUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Joseph Mangmang on 10/23/2017.
 */

public class TourPackageAdapter extends BaseRecyclerViewAdapater<TourPackage, TourPackageAdapter.TourPackageHolder> {

    @Override
    public TourPackageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TourPackageHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.view_item_tour_package, parent, false));
    }

    @Override
    public void onBindViewHolder(TourPackageHolder holder, int position) {
        holder.setData(mDataList.get(position));
        holder.onItemClickListener = mOnItemClickListener;
    }

    class TourPackageHolder extends BaseViewHolder<TourPackage> {
        @BindView(R.id.text_tour_package_title)
        TextView title;
        @BindView(R.id.text_tour_package_price)
        TextView price;
        @BindView(R.id.text_tour_package_number_person)
        TextView numberOfPerson;
        @BindView(R.id.text_tour_package_total_review)
        TextView totalReview;
        @BindView(R.id.tour_package_image_slider)
        ImageSlider imageSlider;
        @BindView(R.id.tour_package_rating_bar)
        RatingBar ratingBar;

        public TourPackageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(TourPackage tourPackage) {
            Preconditions.checkNotNull(tourPackage);
            data = tourPackage;
            title.setText(tourPackage.title());
            PriceOption priceOption = tourPackage.priceOptions().get(0);
            price.setText(priceOption.price().currency() + priceOption.price().displayAmount());
            numberOfPerson.setText(itemView.getContext().getResources().getQuantityString(R.plurals.message_number_of_person, priceOption.numberOfPerson(), priceOption.numberOfPerson()));
            totalReview.setText(tourPackage.totalReviews());
            ratingBar.setRating((float) tourPackage.rating());
            imageSlider.setDataList(Dummy.getTourDestinations());
            imageSlider.showCircleIndicator(false);
        }
    }
}
