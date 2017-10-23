package com.travazar.tour.packages.ui.views.list.base;

import android.content.Context;
import android.content.res.TypedArray;
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
    @BindView(R.id.text_list_title)
    TextView mTitle;
    @BindView(R.id.text_list_more)
    TextView mMore;
    @BindView(R.id.list_recycler_view)
    protected RecyclerView mRecyclerView;

    public ListViewLayout(Context context) {
        super(context);
        init(null);
    }

    public ListViewLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ListViewLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.view_list_view, this);
        ButterKnife.bind(this);
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ListViewLayout);
            if (a.hasValue(R.styleable.ListViewLayout_title)) {
                String title = a.getString(R.styleable.ListViewLayout_title);
                setTitle(title);
            }
            if (a.hasValue(R.styleable.ListViewLayout_showMoreButton)) {
                boolean show = a.getBoolean(R.styleable.ListViewLayout_showMoreButton, true);
                showMoreButton(show);
            }
        }
        onPrepareRecyclerView();

    }

    private void showMoreButton(boolean show) {
        mMore.setVisibility(show ? VISIBLE : GONE);
    }

    protected abstract void onPrepareRecyclerView();

    public void setTitle(@StringRes int title) {
        mTitle.setText(title);
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public void setMoreButtonClickListener(OnClickListener clickListener) {
        mMore.setOnClickListener(clickListener);
    }

}
