package com.travazar.tour.packages.ui.views.list.attraction;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.dummy.Dummy;
import com.travazar.tour.packages.ui.views.list.base.ListViewLayout;

import java.util.List;

/**
 * Created by kali_root on 10/13/2017.
 */

public class AttractionListLayout extends ListViewLayout {
    private List<Attraction> mAttractions;
    private TopAttractionAdapter mAdapter;

    public AttractionListLayout(Context context) {
        super(context);
    }

    public AttractionListLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AttractionListLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onPrepareRecyclerView() {
        mAttractions = Dummy.getTopAttractions();
        mAdapter = new TopAttractionAdapter(mAttractions);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
    }
}
