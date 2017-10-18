/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/17/17 9:56 PM
 */

package com.travazar.tour.packages.ui.base;

import android.app.Fragment;
import android.content.Context;

/**
 * Created by kali_root on 10/17/2017.
 */

public class BaseFragment extends Fragment {
    protected BaseActivity mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (BaseActivity) context;
    }
}
