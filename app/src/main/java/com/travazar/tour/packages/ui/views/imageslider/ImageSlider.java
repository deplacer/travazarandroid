package com.travazar.tour.packages.ui.views.imageslider;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.Slider;

import java.util.List;

import me.relex.circleindicator.CircleIndicator;


public class ImageSlider extends RelativeLayout {
    private static final String TAG = ImageSlider.class.getSimpleName();
    private TextView titleText;
    private TextView textIndicator;
    private ViewPager viewPager;
    private SliderAdapter adapter;
    private CircleIndicator circleIndicator;
    private Handler autoNextHandler = new Handler();

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            titleText.setText(adapter.getPageTitle(position));
            textIndicator.setText(position + 1 + "/" + adapter.getCount());
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private boolean autoNext;

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
        viewPager = (ViewPager) findViewById(R.id.slider_view_pager);
        titleText = (TextView) findViewById(R.id.text_slider_title);
        textIndicator = (TextView) findViewById(R.id.text_slider_indicator_right_top);
        circleIndicator = (CircleIndicator) findViewById(R.id.indicator);

        adapter = new SliderAdapter(context);

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        //circleIndicator.setViewPager(viewPager);
        runAutoNext();
    }


    public void setDataList(List<Slider> imageUrls) {
        adapter.setSliders(imageUrls);
        circleIndicator.setViewPager(viewPager);
        onPageChangeListener.onPageSelected(viewPager.getCurrentItem());
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
        autoNextHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (autoNext) {
                    int currentItem = viewPager.getCurrentItem();
                    int nextItem = currentItem + 1;
                    if (currentItem >= (adapter.getCount() - 1)) {
                        nextItem = 0;
                    }
                    viewPager.setCurrentItem(nextItem, true);
                }
                runAutoNext();
            }
        }, 5000);
    }
}
