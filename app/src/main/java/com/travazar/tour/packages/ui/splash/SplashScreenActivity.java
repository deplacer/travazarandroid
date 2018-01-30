package com.travazar.tour.packages.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.ui.base.BaseActivity;
import com.travazar.tour.packages.ui.main.MainActivity;

/**
 * Created by kali_root on 1/30/2018.
 */

public class SplashScreenActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                        finish();
                    }
                }, 5000);
    }
}
