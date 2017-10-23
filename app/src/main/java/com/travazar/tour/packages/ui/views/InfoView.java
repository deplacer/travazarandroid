/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/18/17 5:20 PM
 */

package com.travazar.tour.packages.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.travazar.tour.packages.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kali_root on 10/18/2017.
 */

public class InfoView extends CardView {
    @BindView(R.id.text_info_title)
    TextView mTitle;
    @BindView(R.id.text_info_body)
    TextView mBody;

    @OnClick(R.id.button_info_show_more)
    void onShowMoreClick(View view) {
        view.setVisibility(GONE);
        mBody.setMaxLines(Integer.MAX_VALUE);
    }

    public InfoView(Context context) {
        super(context);
        init(null);
    }

    public InfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public InfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.view_info, this);
        ButterKnife.bind(this);
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.InfoView);
            if (a.hasValue(R.styleable.InfoView_title)) {
                String title = a.getString(R.styleable.InfoView_title);
                mTitle.setText(title);
            }
            a.recycle();
        }
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public void setBody(String body) {
        mBody.setText(body);
    }
}
