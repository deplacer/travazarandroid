package com.travazar.tour.packages.ui.views.list.topattraction;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.travazar.tour.packages.GlideApp;
import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.Attraction;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kali_root on 10/13/2017.
 */

public class TopAttractionAdapter extends RecyclerView.Adapter<TopAttractionAdapter.TopAttractionHolder> {
    private List<Attraction> mAttractions;

    public TopAttractionAdapter(List<Attraction> attractions) {
        mAttractions = attractions;
    }

    @Override
    public TopAttractionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TopAttractionHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_top_attraction, parent, false));
    }

    @Override
    public void onBindViewHolder(TopAttractionHolder holder, int position) {
        Attraction attraction = mAttractions.get(position);
        holder.title.setText(attraction.name());
        GlideApp.with(holder.itemView)
                .load(attraction.imageUrl())
                .placeholder(R.drawable.dummy_image_preview)
                .into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return mAttractions.size();
    }

    class TopAttractionHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_title)
        TextView title;
        @BindView(R.id.image_thumbnail)
        ImageView thumbnail;

        public TopAttractionHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
