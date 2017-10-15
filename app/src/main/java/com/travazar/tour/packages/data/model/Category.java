package com.travazar.tour.packages.data.model;

import com.google.auto.value.AutoValue;

/**
 * Created by kali_root on 10/12/2017.
 */

@AutoValue
public abstract class Category {
    public abstract String title();

    public abstract String backgroundImageUrl();

    public static Builder builder() {
        return new AutoValue_Category.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder title(String title);

        public abstract Builder backgroundImageUrl(String backgroundImageUrl);

        public abstract Category build();
    }
}
