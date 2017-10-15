package com.travazar.tour.packages.ui.views.list.category;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.travazar.tour.packages.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kali_root on 10/12/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private String[] titles = {
            "Nature & Wildlife",
            "Adventure and Travel",
            "Heritage & Cultural",
            "Immersion & Community Based"
    };

    private int[] icons = {
            R.drawable.ic_nature_wildlife,
            R.drawable.ic_adventure_travel,
            R.drawable.ic_heritage_cultural,
            R.drawable.ic_immersion_community_based,
    };


    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_category, parent, false));
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        holder.title.setText(titles[position]);
        holder.title.setCompoundDrawablesWithIntrinsicBounds(0, icons[position], 0, 0);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class CategoryHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_title)
        TextView title;

        public CategoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
