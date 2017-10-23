package com.travazar.tour.packages.ui.tourpackage;

import android.content.Context;

import com.travazar.tour.packages.data.model.TourPackage;
import com.travazar.tour.packages.ui.base.BaseActivity;
import com.travazar.tour.packages.ui.base.BasePresenter;
import com.travazar.tour.packages.ui.base.BaseView;

import java.util.List;

/**
 * Created by Joseph Mangmang on 10/23/2017.
 */

public interface TourPackageListContract {
    interface View extends BaseView<Presenter> {

        void showTourPackages(List<TourPackage> tourPackages);
    }

    interface Presenter extends BasePresenter {

        void requestTourPackage();

        void openTourPackageDetails(Context context, TourPackage tourPackage);
    }
}
