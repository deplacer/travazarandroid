/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/16/17 9:52 PM
 */

package com.travazar.tour.packages.ui.views;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.ui.main.LocationListFragment;

import xyz.sahildave.widget.SearchViewLayout;

/**
 * Created by kali_root on 10/16/2017.
 */

public class LocationSearchViewLayout extends SearchViewLayout {
    private LocationListFragment mLocationListFragment;

    public LocationSearchViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mLocationListFragment = new LocationListFragment();
        showSearchClearIcon(true);
        setCollapsedHint(getContext().getString(R.string.hint_select_location));
        setExpandedHint(getContext().getString(R.string.hint_search_location));
        setSearchClearIcon(R.drawable.ic_location);
        showBurgerIcon();
    }

    public void showBackIcon() {
        setCollapsedIcon(R.drawable.ic_arrow_back);
    }

    public void showBurgerIcon() {
        setCollapsedIcon(R.drawable.ic_burger);
    }
    public void showSearchIcon(){
        setCollapsedIcon(R.drawable.ic_search);
    }
    public void setActivity(FragmentActivity activity) {
        setExpandedContentSupportFragment(activity, mLocationListFragment);
    }

}
