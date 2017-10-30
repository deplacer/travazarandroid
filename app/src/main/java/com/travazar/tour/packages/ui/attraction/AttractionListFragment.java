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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by kali_root on 10/15/2017.
 */

public class AttractionListFragment extends BaseFragment implements
        BaseRecyclerViewAdapater.OnItemClickListener<Attraction>, AttractionListContract.View {
    public static final String TAG = AttractionListFragment.class.getSimpleName();
    @BindView(R.id.attraction_recycler_view)
    RecyclerView mRecyclerView;
    private AttractionAdapter mAdapter;
    private AttractionListContract.Presenter mPresenter;
    private int offset = 0;

    public static AttractionListFragment newInstance() {
        return new AttractionListFragment();
    }

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
        prepreRecyclerView();
        mPresenter.requestAttractions(offset);
        return view;
    }

    private void prepreRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void onItemClick(Attraction data) {
        mPresenter.openAttractionDetails(mContext, data);
    }

    @Override
    public void setPresenter(AttractionListContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public Attraction getAttractionFromList(int position) {
        return mAdapter.getItem(position);
    }

    @Override
    public void showAttractions(List<Attraction> attractions, boolean reset) {
        if (reset) {
            mAdapter.setDataList(attractions);
        } else {
            mAdapter.addDataList(attractions);
        }
    }

    @Override
    public List<Attraction> getLoadedAttractions() {
        return mAdapter.getDataList();
    }
}
