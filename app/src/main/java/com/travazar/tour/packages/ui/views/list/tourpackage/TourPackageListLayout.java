package com.travazar.tour.packages.ui.views.list.tourpackage;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.travazar.tour.packages.data.model.TourPackage;
import com.travazar.tour.packages.dummy.Dummy;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;
import com.travazar.tour.packages.ui.tourpackage.details.TourPackageDetailsActivity;
import com.travazar.tour.packages.ui.views.list.base.ListViewLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kali_root on 10/12/2017.
 */

public class TourPackageListLayout extends ListViewLayout implements BaseRecyclerViewAdapater.OnItemClickListener<TourPackage> {
    List<TourPackage> mTourPackages;
    private TourPackageListAdapter mAdapter;

    public TourPackageListLayout(Context context) {
        super(context);
    }

    public TourPackageListLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TourPackageListLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onPrepareRecyclerView() {
        mTourPackages = new ArrayList<>();
        if (true || isInEditMode()) {
            mTourPackages.add(Dummy.getTourPackage());
            mTourPackages.add(Dummy.getTourPackage());
            mTourPackages.add(Dummy.getTourPackage());
        }
        mAdapter = new TourPackageListAdapter(mTourPackages);
        mAdapter.setOnItemClickListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(TourPackage data) {
        TourPackageDetailsActivity.launch(getContext(), data);
    }
}
