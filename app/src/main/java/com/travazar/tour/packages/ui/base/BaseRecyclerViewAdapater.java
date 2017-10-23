/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/18/17 3:57 PM
 */

package com.travazar.tour.packages.ui.base;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kali_root on 10/18/2017.
 */

public abstract class BaseRecyclerViewAdapater<DataType, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<DataType> mDataList;
    protected OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener<DataType> {
        void onItemClick(DataType data);
    }
    public BaseRecyclerViewAdapater(){
        mDataList = new ArrayList<>();
    }
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    public void setDataList(List<DataType> dataList){
        mDataList = dataList;
        notifyDataSetChanged();
    }
}
