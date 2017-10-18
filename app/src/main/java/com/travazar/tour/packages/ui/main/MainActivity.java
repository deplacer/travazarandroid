package com.travazar.tour.packages.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.ui.attraction.AttractionListActivity;
import com.travazar.tour.packages.ui.base.BaseActivity;
import com.travazar.tour.packages.ui.views.LocationSearchViewLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.sahildave.widget.SearchViewLayout;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_left)
    NavigationView mNavigationView;
    @BindView(R.id.search_view_container)
    LocationSearchViewLayout mSearchViewLayout;
    @BindView(R.id.navigation_bottom)
    BottomNavigationView mBottomNavigationView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_item_home:
                    break;
                case R.id.navigation_item_attractions:
                    openAttractionList();
                    break;
                case R.id.navigation_item_tour_packages:
                    break;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        switchFragment(new MainFragment());
        setupNavigationDrawer();
        setupSearchViewLayout();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return false;
    }

    private void setupSearchViewLayout() {
        mSearchViewLayout.setActivity(this);
        mSearchViewLayout.handleToolbarAnimation(getToolbar());
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
        Menu bottomMenu = mBottomNavigationView.getMenu();
        bottomMenu.findItem(R.id.navigation_item_attractions).setCheckable(false);
        bottomMenu.findItem(R.id.navigation_item_tour_packages).setCheckable(false);
    }


    private void openAttractionList() {
        startActivity(AttractionListActivity.class);
    }

    private void onBurgerClick() {
        if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawer(Gravity.START);
        } else {
            mDrawerLayout.openDrawer(Gravity.START);
        }
    }
}
