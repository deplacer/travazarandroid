package com.travazar.tour.packages.ui.views.list.category;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;
import com.travazar.tour.packages.ui.views.list.base.ListViewLayout;

/**
 * Created by kali_root on 10/12/2017.
 */

public class CategoryListViewLayout extends ListViewLayout {
    private CategoryAdapter adapter;

    public CategoryListViewLayout(Context context) {
        super(context);
    }

    public CategoryListViewLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CategoryListViewLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onPrepareRecyclerView() {
        setTitle(R.string.title_category);
        adapter = new CategoryAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
    }

    public void setOnItemClickListener(BaseRecyclerViewAdapater.OnItemClickListener itemClickListener) {
        adapter.setOnItemClickListener(itemClickListener);
    }
}
