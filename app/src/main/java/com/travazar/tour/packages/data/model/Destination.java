package com.travazar.tour.packages.data.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Created by kali_root on 10/12/2017.
 */
@AutoValue
public abstract class Destination implements Parcelable {
    public abstract int destinationId();

    public abstract int tourPackageId();

    public abstract Attraction attraction();

    public abstract String daySequence();

    public abstract String time();

    public abstract String notes();

    public static Builder builder() {
        return new AutoValue_Destination.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder destinationId(int destinationId);

        public abstract Builder tourPackageId(int tourPackageId);

        public abstract Builder attraction(Attraction attraction);

        public abstract Builder daySequence(String daySequence);

        public abstract Builder time(String time);

        public abstract Builder notes(String notes);

        public abstract Destination build();
    }
}
