package com.travazar.tour.packages.ui.attraction;

/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/19/17 5:45 PM
 */

import android.content.Context;

import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.ui.base.BasePresenter;
import com.travazar.tour.packages.ui.base.BaseView;

/**
 * Created by kali_root on 10/19/2017.
 */

public interface AttractionListContract {
    interface View extends BaseView<Presenter>{
    }
    interface Presenter extends BasePresenter{

        void openAttractionDetails(Context context, Attraction attraction);

        void detectCurrentLocation();
    }
}
