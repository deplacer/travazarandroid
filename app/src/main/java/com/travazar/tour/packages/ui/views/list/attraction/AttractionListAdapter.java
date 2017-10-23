package com.travazar.tour.packages.ui.views.list.attraction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.travazar.tour.packages.GlideApp;
import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;
import com.travazar.tour.packages.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kali_root on 10/13/2017.
 */

public class AttractionListAdapter extends BaseRecyclerViewAdapater<Attraction, AttractionListAdapter.TopAttractionHolder> {

    public AttractionListAdapter(List<Attraction> attractions) {
        mDataList = attractions;
    }

    @Override
    public TopAttractionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TopAttractionHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_top_attraction, parent, false));
    }

    @Override
    public void onBindViewHolder(TopAttractionHolder holder, int position) {
        Attraction attraction = mDataList.get(position);
        holder.onItemClickListener = mOnItemClickListener;
        holder.title.setText(attraction.name());
        GlideApp.with(holder.itemView)
                .load(attraction.imageUrl())
                .placeholder(R.drawable.dummy_image_preview)
                .into(holder.thumbnail);

    }

    class TopAttractionHolder extends BaseViewHolder<Attraction> {
        @BindView(R.id.text_attraction_title)
        TextView title;
        @BindView(R.id.image_attraction_thumbnail)
        ImageView thumbnail;

        public TopAttractionHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
