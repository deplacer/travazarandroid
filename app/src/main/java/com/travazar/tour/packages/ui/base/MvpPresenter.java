package com.travazar.tour.packages.ui.base;

/**
 * Created by kali_root on 10/12/2017.
 */

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V mvpView);
}
