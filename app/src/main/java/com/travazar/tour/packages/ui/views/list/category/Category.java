package com.travazar.tour.packages.ui.views.list.category;

import android.support.annotation.DrawableRes;

import com.travazar.tour.packages.R;

/**
 * Created by Joseph Mangmang on 10/24/2017.
 */

public enum Category {
    NatureAndWildlife("Nature & Wildlife", R.drawable.ic_nature_wildlife),
    AdventureAndTravel("Adventure and Travel", R.drawable.ic_adventure_travel),
    HeritageAndCultural("Heritage & Cultural", R.drawable.ic_heritage_cultural),
    ImmersionAndCommunityBased("Immersion & Community Based", R.drawable.ic_immersion_community_based);
    String name;
    @DrawableRes
    int icon;

    Category(String name, @DrawableRes int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    @DrawableRes
    public int getIcon() {
        return icon;
    }
}
