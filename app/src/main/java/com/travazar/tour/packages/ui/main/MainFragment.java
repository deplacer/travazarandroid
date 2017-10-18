package com.travazar.tour.packages.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.dummy.Dummy;
import com.travazar.tour.packages.ui.base.BaseFragment;
import com.travazar.tour.packages.ui.views.imageslider.ImageSlider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kali_root on 10/12/2017.
 */

public class MainFragment extends BaseFragment {
    @BindView(R.id.slider_features)
    ImageSlider mFeaturesSlider;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        mFeaturesSlider.setDataList(Dummy.getFeatures());
        mFeaturesSlider.showTitle(false);
        mFeaturesSlider.setAutoNext(true);
        mFeaturesSlider.showTextIndicator(false);
        return view;
    }
}
