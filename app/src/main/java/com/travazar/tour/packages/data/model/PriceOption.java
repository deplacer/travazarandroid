package com.travazar.tour.packages.data.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.travazar.tour.packages.data.model.base.Price;

/**
 * Created by kali_root on 10/12/2017.
 */

@AutoValue
public abstract class PriceOption implements Parcelable {
    public abstract int priceOptionId();

    public abstract int tourPackageId();

    public abstract int numberOfPerson();

    public abstract Price price();

    public static Builder builder() {
        return new AutoValue_PriceOption.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder priceOptionId(int priceOptionId);

        public abstract Builder tourPackageId(int tourPackageId);

        public abstract Builder numberOfPerson(int numberOfPerson);

        public abstract Builder price(Price price);

        public abstract PriceOption build();
    }
}
