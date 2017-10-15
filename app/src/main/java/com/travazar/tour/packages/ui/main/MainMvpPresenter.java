package com.travazar.tour.packages.ui.main;

import com.travazar.tour.packages.ui.base.MvpPresenter;

/**
 * Created by kali_root on 10/13/2017.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
    void decideNextScreen();
}
