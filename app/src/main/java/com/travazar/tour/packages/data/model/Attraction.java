package com.travazar.tour.packages.data.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Created by kali_root on 10/12/2017.
 */

@AutoValue
public abstract class Attraction implements Parcelable {
    public abstract int attractionId();
    public abstract String name();
    public abstract String imageUrl();
    public abstract double latitude();
    public abstract double longitude();
    public abstract double rating();
    public abstract String totalReviews();
    public abstract String country();
    public abstract String region();
    public abstract String province();
    public abstract String overview();



    public static Builder builder() {
        return new AutoValue_Attraction.Builder();
    }

    public String getAddress() {
        return province() + ", "  + country();
    }

    public static Attraction create(int attractionId, String name, String imageUrl, double latitude, double longitude, double rating, String totalReviews, String country, String region, String province, String overview) {
        return builder()
                .attractionId(attractionId)
                .name(name)
                .imageUrl(imageUrl)
                .latitude(latitude)
                .longitude(longitude)
                .rating(rating)
                .totalReviews(totalReviews)
                .country(country)
                .region(region)
                .province(province)
                .overview(overview)
                .build();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder attractionId(int attractionId);

        public abstract Builder name(String name);

        public abstract Builder imageUrl(String imageUrl);

        public abstract Builder latitude(double latitude);

        public abstract Builder longitude(double longitude);

        public abstract Builder country(String country);

        public abstract Builder region(String region);

        public abstract Builder province(String province);

        public abstract Builder overview(String overview);

        public abstract Builder rating(double rating);

        public abstract Builder totalReviews(String totalReviews);

        public abstract Attraction build();
    }
}
