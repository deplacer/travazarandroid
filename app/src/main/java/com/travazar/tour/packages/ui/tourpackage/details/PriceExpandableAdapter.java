package com.travazar.tour.packages.ui.tourpackage.details;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.PriceOption;

import java.util.List;

import timber.log.Timber;

/**
 * Created by kali_root on 11/13/2017.
 */

public class PriceExpandableAdapter extends BaseExpandableListAdapter {
    private final String priceGroupHeader = "Price List";
    private List<PriceOption> priceOptions;
    private Context mContext;

    public PriceExpandableAdapter(Context context, List<PriceOption> priceOptions) {
        this.priceOptions = priceOptions;
        this.mContext = context;
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int i) {
        return priceOptions.size();
    }

    @Override
    public Object getGroup(int i) {
        return priceGroupHeader;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return priceOptions.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int i, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int pisition, boolean expanded, View view, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(pisition);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_expanded_header, null);
        }
        TextView header = (TextView) view.findViewById(R.id.text_header_title);
        header.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        Timber.d("getChildView is called: %d", childPosition);
        PriceOption priceOption = (PriceOption) getChild(groupPosition, childPosition);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item_expanded_child, null);
        }
        TextView optionRange = (TextView) view.findViewById(R.id.text_child_title);
        TextView optionPrice = (TextView) view.findViewById(R.id.text_child_price);
        try {
            String personRange = mContext.getResources().getQuantityString(R.plurals.person_range, priceOption.numberOfPerson(), priceOption.numberOfPerson());
            optionRange.setText(personRange);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        optionPrice.setText(priceOption.price().currency() + priceOption.price().displayAmount());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

}
