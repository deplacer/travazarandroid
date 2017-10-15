package com.travazar.tour.packages.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.DataManager;
import com.travazar.tour.packages.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_left)
    NavigationView mNavigationView;

    private MainPresenter mMainPresenter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_item_home:
                    openMainPage();
                    return true;
                case R.id.navigation_item_attractions:
                    openAttractionPage();
                    return true;
                case R.id.navigation_item_tour_packages:
                    openTourPackagePage();
                    return true;
            }
            return false;
        }

    };

    @OnClick(R.id.image_burger)
    void onBurgerClick() {
        if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawer(Gravity.START);
        } else {
            mDrawerLayout.openDrawer(Gravity.START);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DataManager dataManager = getApp().getDataManager();
        mMainPresenter = new MainPresenter(dataManager);
        mMainPresenter.onAttach(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_bottom);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        openMainPage();
        setupNavigationDrawer();
    }

    private void setupNavigationDrawer() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(drawerToggle);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void openMainPage() {
        switchFragment(new MainFragment());
    }

    @Override
    public void openAttractionPage() {
    }

    @Override
    public void openTourPackagePage() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return false;
    }
}
