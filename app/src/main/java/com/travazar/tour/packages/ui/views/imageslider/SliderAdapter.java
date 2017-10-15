package com.travazar.tour.packages.ui.views.imageslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.travazar.tour.packages.GlideApp;
import com.travazar.tour.packages.R;

import java.util.ArrayList;
import java.util.List;



public class SliderAdapter extends PagerAdapter {
    private List<String> imageUrls;
    private LayoutInflater mInflater;
    private Context context;

    public SliderAdapter(Context context) {
        this(context, null);
    }

    public SliderAdapter(Context context, List<String> imageUrls) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        if (imageUrls == null) {
            this.imageUrls = new ArrayList<>();
        } else {
            this.imageUrls = imageUrls;
        }
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = (ImageView) mInflater.inflate(R.layout.view_slider, container, false);
        String url = imageUrls.get(position);
        GlideApp.with(context)
                .load(url)
                .thumbnail(0.1f)
                .placeholder(R.drawable.dummy_image_preview)
                .into(view);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        notifyDataSetChanged();
    }

}
