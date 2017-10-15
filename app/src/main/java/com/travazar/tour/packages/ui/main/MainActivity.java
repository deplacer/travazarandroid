package com.travazar.tour.packages.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.DataManager;
import com.travazar.tour.packages.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.sahildave.widget.SearchViewLayout;

public class MainActivity extends BaseActivity implements MainMvpView, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_left)
    NavigationView mNavigationView;
    @BindView(R.id.search_view_container)
    SearchViewLayout mSearchViewLayout;
    @BindView(R.id.navigation_bottom)
    BottomNavigationView mBottomNavigationView;

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
    private SearchViewLayout.OnToggleAnimationListener mSearchViewToggleListener = new SearchViewLayout.OnToggleAnimationListener() {
        @Override
        public void onStart(boolean expanding) {
            mBottomNavigationView.setVisibility(expanding ? View.GONE : View.VISIBLE);
        }

        @Override
        public void onFinish(boolean expanded) {

        }
    };

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
        openMainPage();
        setupNavigationDrawer();
        setupSearchViewLayout();
    }

    private void setupSearchViewLayout() {
        mSearchViewLayout.setExpandedContentSupportFragment(this, new LocationListFragment());
        mSearchViewLayout.handleToolbarAnimation(getToolbar());
        mSearchViewLayout.showSearchClearIcon(true);
        mSearchViewLayout.setCollapsedHint(getString(R.string.hint_select_location));
        mSearchViewLayout.setExpandedHint(getString(R.string.hint_search_location));
        mSearchViewLayout.setCollapsedIcon(R.drawable.ic_burger);
        mSearchViewLayout.setSearchClearIcon(R.drawable.ic_location);
        mSearchViewLayout.setOnToggleAnimationListener(mSearchViewToggleListener);
        mSearchViewLayout.setSearchIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBurgerClick();
            }
        });
        mSearchViewLayout.setSearchClearOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 10/15/2017 implement get current location
            }
        });

    }

    private void setupNavigationDrawer() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(drawerToggle);
        mNavigationView.setNavigationItemSelectedListener(this);
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
