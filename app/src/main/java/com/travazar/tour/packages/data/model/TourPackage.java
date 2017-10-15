package com.travazar.tour.packages.data.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Created by kali_root on 10/12/2017.
 */
@AutoValue
public abstract class TourPackage implements Parcelable {
    public abstract int tourPackageId();

    public abstract int tourOperatorId();

    public abstract String title();

    public abstract String tourCode();

    public abstract String departurePoint();

    public abstract String departureTime();

    public abstract String returnTime();

    public abstract String location();

    public abstract String duration();

    public abstract String inclusions();

    public abstract String exclusions();

    public abstract String description();

    public abstract String shortDescription();

    public abstract String highlights();

    public abstract String termAndConditions();

    public abstract String voucherInfo();

    public abstract boolean available();

    public abstract String additionalInfo();

    public abstract List<PriceOption> priceOptions();

    public abstract List<Destination> destinations();

    public static Builder builder() {
        return new AutoValue_TourPackage.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder tourPackageId(int tourPackageId);

        public abstract Builder tourOperatorId(int tourOperatorId);

        public abstract Builder title(String title);

        public abstract Builder tourCode(String tourCode);

        public abstract Builder departurePoint(String departurePoint);

        public abstract Builder departureTime(String departureTime);

        public abstract Builder returnTime(String returnTime);

        public abstract Builder location(String location);

        public abstract Builder duration(String duration);

        public abstract Builder inclusions(String inclusions);

        public abstract Builder exclusions(String exclusions);

        public abstract Builder description(String description);

        public abstract Builder shortDescription(String shortDescription);

        public abstract Builder highlights(String highlights);

        public abstract Builder termAndConditions(String termAndConditions);

        public abstract Builder voucherInfo(String voucherInfo);

        public abstract Builder available(boolean available);

        public abstract Builder additionalInfo(String additionalInfo);

        public abstract Builder priceOptions(List<PriceOption> priceOptions);

        public abstract Builder destinations(List<Destination> destinations);

        public abstract TourPackage build();
    }
}
