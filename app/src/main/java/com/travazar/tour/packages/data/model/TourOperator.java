package com.travazar.tour.packages.data.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Created by kali_root on 10/12/2017.
 */
@AutoValue
public abstract class TourOperator implements Parcelable {

    public abstract int tourOperatorId();

    public abstract String name();

    public abstract String email();

    public abstract String address();

    public abstract String contactNumber();

    public abstract String description();

    public abstract List<TourPackage> tourPackages();

    public static Builder builder() {
        return new AutoValue_TourOperator.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder tourOperatorId(int tourOperatorId);

        public abstract Builder name(String name);

        public abstract Builder email(String email);

        public abstract Builder address(String address);

        public abstract Builder contactNumber(String contactNumber);

        public abstract Builder description(String description);

        public abstract Builder tourPackages(List<TourPackage> tourPackages);

        public abstract TourOperator build();
    }
}

