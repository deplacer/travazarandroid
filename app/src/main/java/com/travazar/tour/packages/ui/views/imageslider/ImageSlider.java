package com.travazar.tour.packages.ui.views.imageslider;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.Slider;

import java.lang.ref.WeakReference;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;


public class ImageSlider extends RelativeLayout {
    private static final String TAG = ImageSlider.class.getSimpleName();
    private TextView titleText;
    private TextView textIndicator;
    private WeakReference<ViewPager> viewPagerWeakReference;
    private WeakReference<SliderAdapter> adapterWeakReference;
    private CircleIndicator circleIndicator;

    private boolean autoNext;
    private final Runnable mAutoNextRunnable = new Runnable() {
        @Override
        public void run() {
            if (autoNext) {
                int currentItem = viewPagerWeakReference.get().getCurrentItem();
                int nextItem = currentItem + 1;
                if (currentItem >= (adapterWeakReference.get().getCount() - 1)) {
                    nextItem = 0;
                }
                viewPagerWeakReference.get().setCurrentItem(nextItem, true);
            }
            runAutoNext();
        }
    };

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            titleText.setText(adapterWeakReference.get().getPageTitle(position));
            textIndicator.setText(position + 1 + "/" + adapterWeakReference.get().getCount());
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public ImageSlider(Context context) {
        super(context);
        init(context);
    }

    public ImageSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.view_image_slider, this);
        viewPagerWeakReference = new WeakReference<>((ViewPager) findViewById(R.id.slider_view_pager));
        titleText = (TextView) findViewById(R.id.text_slider_title);
        textIndicator = (TextView) findViewById(R.id.text_slider_indicator_right_top);
        circleIndicator = (CircleIndicator) findViewById(R.id.indicator);

        adapterWeakReference = new WeakReference<>(new SliderAdapter(context));

        viewPagerWeakReference.get().setAdapter(adapterWeakReference.get());
        viewPagerWeakReference.get().addOnPageChangeListener(onPageChangeListener);
        //circleIndicator.setViewPager(viewPager);
        runAutoNext();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(mAutoNextRunnable);
    }

    public void setDataList(List<Slider> imageUrls) {
        adapterWeakReference.get().setSliders(imageUrls);
        circleIndicator.setViewPager(viewPagerWeakReference.get());
        onPageChangeListener.onPageSelected(viewPagerWeakReference.get().getCurrentItem());
    }

    public void showCircleIndicator(boolean show) {
        circleIndicator.setVisibility(show ? VISIBLE : GONE);
    }

    public void showTextIndicator(boolean show) {
        textIndicator.setVisibility(show ? VISIBLE : GONE);
    }

    public void showTitle(boolean show) {
        titleText.setVisibility(show ? VISIBLE : GONE);
    }

    public void setAutoNext(boolean autoNext) {
        this.autoNext = autoNext;

    }

    private void runAutoNext() {
        postDelayed(mAutoNextRunnable, 5000);
    }
}
