/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/16/17 8:11 PM
 */

package com.travazar.tour.packages.ui.attraction;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.ui.base.BaseListActivity;
import com.travazar.tour.packages.ui.views.LocationSearchViewLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.sahildave.widget.SearchViewLayout;

/**
 * Created by kali_root on 10/16/2017.
 */

public class AttractionListActivity extends BaseListActivity<AttractionListFragment, AttractionMapFragment> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
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
