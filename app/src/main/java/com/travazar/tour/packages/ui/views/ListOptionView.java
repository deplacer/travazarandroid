/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/17/17 11:13 PM
 */

package com.travazar.tour.packages.ui.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.travazar.tour.packages.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kali_root on 10/17/2017.
 */

public class ListOptionView extends LinearLayout {
    @BindView(R.id.text_filter)
    View mFilterButton;
    @BindView(R.id.text_sort)
    View mSortButton;
    @BindView(R.id.text_map)
    View mMapButton;

    @OnClick({R.id.text_filter, R.id.text_sort, R.id.text_map})
    void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.text_filter:
                break;
            case R.id.text_sort:
                break;
            case R.id.text_map:
                break;
        }
    }

    public ListOptionView(Context context) {
        super(context);
        init();
    }

    public ListOptionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ListOptionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_list_option, this);
        ButterKnife.bind(this);
    }

    public void setFilterButtonClickListener(OnClickListener clickListener) {
        mFilterButton.setOnClickListener(clickListener);
    }

    public void setSortButtonClickListener(OnClickListener clickListener) {
        mSortButton.setOnClickListener(clickListener);
    }

    public void setMapButtonClickListener(OnClickListener clickListener) {
        mMapButton.setOnClickListener(clickListener);
    }

    public void switchButtonToList() {
        TextView mMapButton = (TextView) this.mMapButton;
        mMapButton.setText(R.string.title_list);
        mMapButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_list, 0, 0, 0);
    }
    public void switchButtonToMap() {
        TextView mMapButton = (TextView) this.mMapButton;
        mMapButton.setText(R.string.title_map);
        mMapButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_map, 0, 0, 0);
    }
}
