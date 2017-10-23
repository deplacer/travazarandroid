package com.travazar.tour.packages.ui.tourpackage;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.travazar.tour.packages.ui.attraction.AttractionMapFragment;
import com.travazar.tour.packages.ui.base.BaseListActivity;

/**
 * Created by Joseph Mangmang on 10/23/2017.
 */

public class TourPackageListActivity extends BaseListActivity<TourPackageListFragment, AttractionMapFragment> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new TourPackageListPresenter(mListFragment);
    }

    @Override
    protected TourPackageListFragment getListFragment() {
        return TourPackageListFragment.newInstance();
    }

    @Override
    protected AttractionMapFragment getMapFragment() {
        return AttractionMapFragment.newInstance();
    }
}
