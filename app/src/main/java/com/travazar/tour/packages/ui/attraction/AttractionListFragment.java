package com.travazar.tour.packages.ui.attraction;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.ui.base.BaseFragment;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kali_root on 10/15/2017.
 */

public class AttractionListFragment extends BaseFragment implements BaseRecyclerViewAdapater.OnItemClickListener<Attraction>{
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private AttractionAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new AttractionAdapter();
        mAdapter.setOnItemClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attraction_list, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onItemClick(Attraction data) {

    }
}
