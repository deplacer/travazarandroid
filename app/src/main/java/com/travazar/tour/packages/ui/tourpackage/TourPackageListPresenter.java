package com.travazar.tour.packages.ui.tourpackage;

import android.content.Context;

import com.bumptech.glide.util.Preconditions;
import com.travazar.tour.packages.data.model.TourPackage;
import com.travazar.tour.packages.dummy.Dummy;
import com.travazar.tour.packages.ui.tourpackage.details.TourPackageDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by Joseph Mangmang on 10/23/2017.
 */

public class TourPackageListPresenter implements TourPackageListContract.Presenter{
    private final TourPackageListContract.View mTourPackageView;

    public TourPackageListPresenter(TourPackageListContract.View tourPackageView) {
        mTourPackageView = Preconditions.checkNotNull(tourPackageView);
        mTourPackageView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void requestTourPackage() {
        mTourPackageView.showTourPackages(Dummy.getTourPackages());
    }

    @Override
    public void openTourPackageDetails(Context context, TourPackage tourPackage) {
        checkNotNull(tourPackage);
        TourPackageDetailsActivity.launch(context, tourPackage);
    }
}
