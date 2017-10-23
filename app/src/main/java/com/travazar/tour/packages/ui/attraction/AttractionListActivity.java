/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/16/17 8:11 PM
 */

package com.travazar.tour.packages.ui.attraction;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.ui.base.BaseActivity;
import com.travazar.tour.packages.ui.views.ListOptionView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kali_root on 10/16/2017.
 */

public class AttractionListActivity extends BaseActivity {
    @BindView(R.id.list_option_view)
    ListOptionView mListOptionView;
    private AttractionListFragment mAttractionListFragment;
    private AttractionMapFragment mMapFragment;
    private BottomSheetBehavior<ListOptionView> mBottomSheet;

    private View.OnClickListener mFilterButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (mBottomSheet.getState()) {
                case BottomSheetBehavior.STATE_COLLAPSED:
                    mBottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
                    break;
                case BottomSheetBehavior.STATE_EXPANDED:
                    mBottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    break;
            }
        }
    };
    private View.OnClickListener mMapButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switchFragment();
        }
    };
    private boolean mapButtonVisible = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_list);
        ButterKnife.bind(this);
        showBackButton(true);

        mAttractionListFragment = (AttractionListFragment) getFragmentManager()
                .findFragmentByTag(AttractionListFragment.TAG);
        mMapFragment = (AttractionMapFragment) getFragmentManager()
                .findFragmentByTag(AttractionMapFragment.TAG);

        if (mAttractionListFragment == null) {
            mAttractionListFragment = switchFragment(AttractionListFragment.newInstance());
        }
        if (mMapFragment == null) {
            mMapFragment = AttractionMapFragment.newInstance();
        }
        new AttractionListPresenter(mAttractionListFragment);

        mBottomSheet = BottomSheetBehavior.from(mListOptionView);
        mListOptionView.setFilterButtonClickListener(mFilterButtonClickListener);
        mListOptionView.setSortButtonClickListener(mFilterButtonClickListener);
        mListOptionView.setMapButtonClickListener(mMapButtonClickListener);
    }


    @Override
    public boolean onSupportNavigateUp() {
        if (!getFragmentManager().popBackStackImmediate()) {
            super.onBackPressed();
        }
        return true;
    }

    private void switchFragment() {
        if (mapButtonVisible) {
            mapButtonVisible = false;
            mListOptionView.switchButtonToList();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, mMapFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null)
                    .commit();
        } else {
            mapButtonVisible = true;
            mListOptionView.switchButtonToMap();
            getFragmentManager().popBackStackImmediate();
        }
    }
}
