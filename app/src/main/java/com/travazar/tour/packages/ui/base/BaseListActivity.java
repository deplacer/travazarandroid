package com.travazar.tour.packages.ui.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.ui.attraction.AttractionListFragment;
import com.travazar.tour.packages.ui.views.ListOptionView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Joseph Mangmang on 10/23/2017.
 */

public abstract class BaseListActivity<ListFrag extends Fragment, MapFrag extends Fragment> extends BaseActivity {
    private static final String TAG_LIST = "list_tag";
    private static final String TAG_MAP = "map_tag";
    @BindView(R.id.list_option_view)
    protected ListOptionView mListOptionView;
    protected BottomSheetBehavior<ListOptionView> mBottomSheet;
    protected ListFrag mListFragment;
    protected MapFrag mMapFragment;

    private View.OnClickListener mFilterButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (mBottomSheet.getState()) {
                case BottomSheetBehavior.STATE_COLLAPSED:
                    mBottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
                    break;
                case BottomSheetBehavior.STATE_EXPANDED:
                    mBottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    break;
            }
        }
    };
    private View.OnClickListener mMapButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switchFragment();
        }
    };
    private boolean mapButtonVisible = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        showBackButton(true);

        mListFragment = (ListFrag) getFragmentManager()
                .findFragmentByTag(TAG_LIST);
        if (mListFragment == null) {
            mListFragment = getListFragment();
        }
        mMapFragment = (MapFrag) getFragmentManager()
                .findFragmentByTag(TAG_MAP);
        if (mMapFragment == null) {
            mMapFragment = getMapFragment();
        }
        if (savedInstanceState == null) {
            switchFragment(mListFragment, TAG_LIST);
        }
        mBottomSheet = BottomSheetBehavior.from(mListOptionView);
        mListOptionView.setFilterButtonClickListener(mFilterButtonClickListener);
        mListOptionView.setSortButtonClickListener(mFilterButtonClickListener);
        mListOptionView.setMapButtonClickListener(mMapButtonClickListener);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (!getFragmentManager().popBackStackImmediate()) {
            super.onBackPressed();
        }
        return true;
    }

    private void switchFragment() {
        if (mapButtonVisible) {
            mapButtonVisible = false;
            mListOptionView.switchButtonToList();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, mMapFragment, TAG_MAP)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null)
                    .commit();
        } else {
            mapButtonVisible = true;
            mListOptionView.switchButtonToMap();
            getFragmentManager().popBackStackImmediate();
        }
    }

    protected abstract ListFrag getListFragment();

    protected abstract MapFrag getMapFragment();

}
