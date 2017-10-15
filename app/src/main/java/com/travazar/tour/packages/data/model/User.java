package com.travazar.tour.packages.data.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Created by kali_root on 10/12/2017.
 */

@AutoValue
public abstract class User implements Parcelable {
    public abstract int userId();

    public abstract String name();

    public abstract String email();

    public abstract String profileImageUrl();

    public static Builder builder() {
        return new AutoValue_User.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder userId(int userId);

        public abstract Builder name(String name);

        public abstract Builder email(String email);

        public abstract Builder profileImageUrl(String profileImageUrl);

        public abstract User build();
    }
}
