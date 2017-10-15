package com.travazar.tour.packages.ui.base;

import com.travazar.tour.packages.data.DataManager;

/**
 * Created by kali_root on 10/12/2017.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private V mMvpView;
    private DataManager mDataManager;

    public BasePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public MvpView getMvpView() {
        return mMvpView;
    }
}
