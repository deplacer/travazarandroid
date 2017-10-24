package com.travazar.tour.packages.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.dummy.Dummy;
import com.travazar.tour.packages.ui.base.BaseFragment;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;
import com.travazar.tour.packages.ui.tourpackage.TourPackageListActivity;
import com.travazar.tour.packages.ui.views.imageslider.ImageSlider;
import com.travazar.tour.packages.ui.views.list.category.Category;
import com.travazar.tour.packages.ui.views.list.category.CategoryListViewLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by kali_root on 10/12/2017.
 */

public class MainFragment extends BaseFragment implements MainContract.View {
    @BindView(R.id.slider_features)
    ImageSlider mFeaturesSlider;
    @BindView(R.id.category_list)
    CategoryListViewLayout mCategoryListLayout;

    private MainContract.Presenter mPresenter;

    private BaseRecyclerViewAdapater.OnItemClickListener mCategoryClickListner = new BaseRecyclerViewAdapater.OnItemClickListener<Category>() {
        @Override
        public void onItemClick(Category data) {
            // TODO: 10/24/2017 handle category click
            startActivity(new Intent(mContext, TourPackageListActivity.class));
        }
    };

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        mCategoryListLayout.setOnItemClickListener(mCategoryClickListner);
        prepareFeatureSlider();
        return view;
    }

    private void prepareFeatureSlider() {
        mFeaturesSlider.setDataList(Dummy.getFeatures());
        mFeaturesSlider.showTitle(false);
        mFeaturesSlider.setAutoNext(true);
        mFeaturesSlider.showTextIndicator(false);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
