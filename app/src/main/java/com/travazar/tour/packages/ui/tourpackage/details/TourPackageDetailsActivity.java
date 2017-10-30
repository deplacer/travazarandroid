package com.travazar.tour.packages.ui.tourpackage.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.TourPackage;
import com.travazar.tour.packages.ui.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by Joseph Mangmang on 10/23/2017.
 */

public class TourPackageDetailsActivity extends BaseActivity {
    private static final String EXTRA_TOUR_PACKAGE = "com.travazar.tour.packages.EXTRA_TOUR_PACKAGE";

    private TourPackage mTourPackage;

    public static void launch(Context context, TourPackage tourPackage) {
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
    }

    private TourPackage getTourPackageFromIntent() {
        return getIntent().getParcelableExtra(EXTRA_TOUR_PACKAGE);
    }
}
