/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/16/17 8:11 PM
 */

package com.travazar.tour.packages.ui.attraction;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.travazar.tour.packages.ui.base.BaseListActivity;

/**
 * Created by kali_root on 10/16/2017.
 */

public class AttractionListActivity extends BaseListActivity<AttractionListFragment, AttractionMapFragment> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AttractionListPresenter(mListFragment);

    }

    @Override
    protected AttractionListFragment getListFragment() {
        return AttractionListFragment.newInstance();
    }

    @Override
    protected AttractionMapFragment getMapFragment() {
        return AttractionMapFragment.newInstance();
    }


}
