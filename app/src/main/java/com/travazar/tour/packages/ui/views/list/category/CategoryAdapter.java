package com.travazar.tour.packages.ui.views.list.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.ui.base.BaseRecyclerViewAdapater;
import com.travazar.tour.packages.ui.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.travazar.tour.packages.ui.views.list.category.Category.*;

/**
 * Created by kali_root on 10/12/2017.
 */

public class CategoryAdapter extends BaseRecyclerViewAdapater<Category, CategoryAdapter.CategoryHolder> {

    private Category[] categories = {
            NatureAndWildlife,
            AdventureAndTravel,
            HeritageAndCultural,
            ImmersionAndCommunityBased
    };


    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_category, parent, false));
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        holder.onItemClickListener = mOnItemClickListener;
        holder.setData(categories[position]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class CategoryHolder extends BaseViewHolder<Category> {
        @BindView(R.id.text_category_title)
        TextView title;

        public CategoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(Category category) {
            data = category;
            title.setText(category.getName());
            title.setCompoundDrawablesWithIntrinsicBounds(0, category.getIcon(), 0, 0);
        }
    }
}
