package com.travazar.tour.packages.ui.tourpackage.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RatingBar;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.data.model.Destination;
import com.travazar.tour.packages.data.model.PriceOption;
import com.travazar.tour.packages.data.model.Slider;
import com.travazar.tour.packages.data.model.TourPackage;
import com.travazar.tour.packages.data.model.base.Price;
import com.travazar.tour.packages.ui.base.BaseActivity;
import com.travazar.tour.packages.ui.views.InfoView;
import com.travazar.tour.packages.ui.views.imageslider.ImageSlider;
import com.travazar.tour.packages.ui.views.list.attraction.AttractionListLayout;
import com.travazar.tour.packages.util.FormatterUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Joseph Mangmang on 10/23/2017.
 */

public class TourPackageDetailsActivity extends BaseActivity {
    private static final String EXTRA_TOUR_PACKAGE = "com.travazar.tour.packages.EXTRA_TOUR_PACKAGE";

    @BindView(R.id.image_slider)
    ImageSlider mImageSlider;
    @BindView(R.id.fab_favorite)
    FloatingActionButton mFavoriteFab;
    @BindView(R.id.text_tour_package_title)
    TextView mPackageTitle;
    @BindView(R.id.text_tour_operator)
    TextView mTourOperator;
    @BindView(R.id.text_tour_package_price)
    TextView mPackagePrice;
    @BindView(R.id.text_tour_package_price_currency)
    TextView mPriceCurrency;
    @BindView(R.id.expandable_price_options)
    ExpandableListView mPriceOptions;
    @BindView(R.id.rating)
    RatingBar mRating;
    @BindView(R.id.text_rating)
    TextView mRatingText;
    @BindView(R.id.text_total_reviews)
    TextView mTotalReviews;
    @BindView(R.id.list_layout_dectination)
    AttractionListLayout mDestinationLayout;
    @BindView(R.id.info_view_information)
    InfoView mInformation;
    @BindView(R.id.info_view_overview)
    InfoView mOverview;
    @BindView(R.id.info_view_inclusions)
    InfoView mInclusions;
    @BindView(R.id.info_view_exclusions)
    InfoView mExclusions;
    @BindView(R.id.info_view_term_conditions)
    InfoView mTermConditions;

    private TourPackage mTourPackage;

    public static void launch(Context context, @NonNull TourPackage tourPackage) {
        Intent intent = new Intent(context, TourPackageDetailsActivity.class);
        intent.putExtra(EXTRA_TOUR_PACKAGE, tourPackage);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_package_details);
        ButterKnife.bind(this);
        showBackButton(true);
        mTourPackage = getTourPackageFromIntent();
        prepareDetails();
    }

    private void prepareDetails() {
        mPackageTitle.setText(mTourPackage.title());
        mTourOperator.setText(mTourPackage.tourOperatorName());
        mRating.setRating((float) mTourPackage.rating());
        mRatingText.setText(FormatterUtil.displayedRating(mTourPackage.rating()));
        mTotalReviews.setText(mTourPackage.totalReviews());
        List<PriceOption> priceOptions = mTourPackage.priceOptions();
        if (priceOptions != null && priceOptions.size() > 0) {
            Collections.sort(priceOptions, PriceOption.numberOfPersonComparator());
            Price price = priceOptions.get(0).price();
            mPackagePrice.setText(price.displayAmount());
            mPriceCurrency.setText(price.currency());
        }
        List<Slider> imageUrls = new ArrayList<>();
        for(Destination destination: mTourPackage.destinations()){
            Attraction attraction = destination.attraction();
            imageUrls.add(Slider.builder().imageUrl(attraction.imageUrl()).name(attraction.name()).build());
        }
        mImageSlider.setDataList(imageUrls);
        //      List<Destination> destinations = mTourPackage.destinations();
        //      mDestinationLayout.setData(destinations); // TODO: 11/13/2017 set destination
        mInformation.setBody(FormatterUtil
                .displayedInformation(
                        mTourPackage.available(),
                        mTourPackage.tourCode(),
                        mTourPackage.duration(),
                        mTourPackage.departurePoint(),
                        mTourPackage.departureTime(),
                        mTourPackage.returnTime(),
                        mTourPackage.highlights(),
                        mTourPackage.additionalInfo(),
                        mTourPackage.voucherInfo()));

        mOverview.setBody(mTourPackage.shortDescription());
        mInclusions.setBody(mTourPackage.inclusions());
        mExclusions.setBody(mTourPackage.exclusions());
        mTermConditions.setBody(mTourPackage.termAndConditions());

        PriceExpandableAdapter expandableAdapter = new PriceExpandableAdapter(this, priceOptions);
        mPriceOptions.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View view, int groupPosition, long l) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });
        mPriceOptions.setAdapter(expandableAdapter);
    }

    private TourPackage getTourPackageFromIntent() {
        return getIntent().getParcelableExtra(EXTRA_TOUR_PACKAGE);
    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setListViewHeight(ExpandableListView listView,
                                   int group) {
        ExpandableListAdapter listAdapter = listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10) {
            height = 200;
        }
        params.height = height + 10;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }
}
