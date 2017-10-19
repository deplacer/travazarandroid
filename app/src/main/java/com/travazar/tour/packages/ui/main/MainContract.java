/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/19/17 3:42 PM
 */

package com.travazar.tour.packages.ui.main;

import com.travazar.tour.packages.ui.base.BasePresenter;
import com.travazar.tour.packages.ui.base.BaseView;

/**
 * Created by kali_root on 10/19/2017.
 */

public interface MainContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void detectCurrentLocation();
    }
}
