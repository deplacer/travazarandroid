/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/18/17 4:29 PM
 */

package com.travazar.tour.packages.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kali_root on 10/18/2017.
 */

public class BaseViewHolder<DataType> extends RecyclerView.ViewHolder implements View.OnClickListener {
    public BaseRecyclerViewAdapater.OnItemClickListener<DataType> onItemClickListener;
    public DataType data;

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) onItemClickListener.onItemClick(data);
    }
}
