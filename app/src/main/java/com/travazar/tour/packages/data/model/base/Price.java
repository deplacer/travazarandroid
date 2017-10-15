package com.travazar.tour.packages.data.model.base;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Created by kali_root on 10/12/2017.
 */

@AutoValue
public abstract class Price implements Parcelable {

    public abstract double price();

    public abstract String currency();

    public abstract String displayAmount();

    public static Builder builder() {
        return new AutoValue_Price.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder price(double price);

        public abstract Builder currency(String currency);

        public abstract Builder displayAmount(String displayAmount);

        public abstract Price build();
    }
}
