package com.travazar.tour.packages.data.model;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

/**
 * Created by Joseph Mangmang on 10/23/2017.
 */
@AutoValue
public abstract class Slider {
    @Nullable
    public abstract String name();

    public abstract String imageUrl();

    public static Builder builder() {
        return new AutoValue_Slider.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder imageUrl(String imageUrl);

        public abstract Slider build();
    }
}
