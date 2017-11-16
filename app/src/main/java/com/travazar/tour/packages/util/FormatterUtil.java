package com.travazar.tour.packages.util;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;

import com.travazar.tour.packages.R;
import com.travazar.tour.packages.data.model.PriceOption;
import com.travazar.tour.packages.data.model.base.Price;

/**
 * Created by Joseph Mangmang on 10/23/2017.
 */

public class FormatterUtil {

    public static Spanned displayedPrice(Context context, PriceOption priceOption) {
        Price price = priceOption.price();
        return Html.fromHtml(context.getResources()
                .getQuantityString(R.plurals.displayed_price,
                        priceOption.numberOfPerson(),
                        price.currency(),
                        price.displayAmount(),
                        priceOption.numberOfPerson()));
    }


    public static String displayedRating(double rating) {
        String displayedRating = String.valueOf(rating);
        if (rating >= 8) {
            displayedRating += " Execellent";
        } else if (rating >= 6) {
            displayedRating += " Very Good";
        } else if (rating >= 3) {
            displayedRating += " Good";
        } else if (rating >= 0) {
            displayedRating += " Poor";
        }
        return displayedRating;
    }

    public static Spanned displayedInformation(boolean available, String tourCode, String duration, String departurePoint, String departureTime, String returnTime, String highlights, String additionalInfo, String voucherInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append("<b>Available:</b> " + (available ? "Yes" : "No"));
        builder.append("<br><br>");
        builder.append("<b>Tour Package Code:</b> " + tourCode);
        builder.append("<br><br>");
        builder.append("<b>Duration:</b> " + duration);
        builder.append("<br><br>");
        builder.append("<b>Departure Point:</b> " + departurePoint);
        builder.append("<br><br>");
        builder.append("<b>Departure Time:</b> " + departureTime);
        builder.append("<br><br>");
        builder.append("<b>Return Time:</b> " + returnTime);
        builder.append("<br><br>");
        builder.append("<b>Highlights:</b> <br>" + highlights);
        builder.append("<br><br>");
        builder.append("<b>Additional Info:</b> <br>" + additionalInfo);
        builder.append("<br><br>");
        builder.append("<b>Voucher Info:</b> <br>" + voucherInfo);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(builder.toString(), Html.FROM_HTML_MODE_COMPACT);
        } else {
            return Html.fromHtml(builder.toString());
        }
    }
}
