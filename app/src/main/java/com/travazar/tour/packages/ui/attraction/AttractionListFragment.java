package com.travazar.tour.packages.ui.attraction;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.ui.attraction.details.AttractionDetailsActivity;
import com.travazar.tour.packages.ui.attraction.event.AttractionEvent;
import com.travazar.tour.packages.ui.base.BaseFragment;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by kali_root on 10/15/2017.
 */

public class AttractionListFragment extends BaseFragment implements
        BaseRecyclerViewAdapater.OnItemClickListener<Attraction>, AttractionListContract.View {
    public static final String TAG = AttractionListFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private AttractionAdapter mAdapter;
    private AttractionListContract.Presenter mPresenter;

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
        return view;
    }

    private void prepreRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(Attraction data) {
        mPresenter.opernAttraction(data);
    }

    @Override
    public void setPresenter(AttractionListContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showAttractionDetails(Attraction attraction) {
        EventBus.getDefault().postSticky(new AttractionEvent(attraction));
        AttractionDetailsActivity.launch(mContext);
    }
}
