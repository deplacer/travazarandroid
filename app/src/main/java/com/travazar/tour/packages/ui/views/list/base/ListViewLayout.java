package com.travazar.tour.packages.ui.views.list.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.travazar.tour.packages.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kali_root on 10/12/2017.
 */

public abstract class ListViewLayout extends LinearLayout {
    @BindView(R.id.text_title)
    TextView mTitle;
    @BindView(R.id.recycler_view)
    protected RecyclerView mRecyclerView;

    public ListViewLayout(Context context) {
        super(context);
        init(context);
    }

    public ListViewLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ListViewLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        inflate(context, R.layout.view_list_view, this);
        ButterKnife.bind(this);
        onPrepareRecyclerView();

    }

    protected abstract void onPrepareRecyclerView();

    public void setTitle(@StringRes int title) {
        mTitle.setText(title);
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

}
