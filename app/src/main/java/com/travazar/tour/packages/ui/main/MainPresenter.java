package com.travazar.tour.packages.ui.main;

import com.travazar.tour.packages.data.DataManager;
import com.travazar.tour.packages.ui.base.BasePresenter;

/**
 * Created by kali_root on 10/13/2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void decideNextScreen() {

    }
}
