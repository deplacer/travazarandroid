package com.travazar.tour.packages.ui.tourpackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.util.Preconditions;
import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.TourPackage;
import com.travazar.tour.packages.ui.base.BaseFragment;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;
import com.travazar.tour.packages.ui.tourpackage.details.TourPackageDetailsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by Joseph Mangmang on 10/23/2017.
 */

public class TourPackageListFragment extends BaseFragment implements TourPackageListContract.View,
        BaseRecyclerViewAdapater.OnItemClickListener<TourPackage> {
    @BindView(R.id.tour_package_recycler_view)
    RecyclerView mRecyclerView;

    private TourPackageListContract.Presenter mPresenter;
    private TourPackageAdapter mAdapter;

    public static TourPackageListFragment newInstance() {
        return new TourPackageListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new TourPackageAdapter();
        mAdapter.setOnItemClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tour_package_list, container, false);
        ButterKnife.bind(this, view);
        prepreRecyclerView();
        mPresenter.requestTourPackage();
        return view;
    }

    private void prepreRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setPresenter(TourPackageListContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showTourPackages(List<TourPackage> tourPackages) {
        mAdapter.setDataList(tourPackages);
    }

    @Override
    public void onItemClick(TourPackage data) {
        mPresenter.openTourPackageDetails(mContext, data);
    }

}
