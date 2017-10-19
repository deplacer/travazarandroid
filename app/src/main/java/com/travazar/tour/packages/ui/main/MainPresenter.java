/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/19/17 3:42 PM
 */

package com.travazar.tour.packages.ui.main;


import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by kali_root on 10/19/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View mMainView;

    public MainPresenter(MainContract.View mainView) {
        mMainView = checkNotNull(mainView, "mainView cannot be null");
        mMainView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void detectCurrentLocation() {

    }
}
