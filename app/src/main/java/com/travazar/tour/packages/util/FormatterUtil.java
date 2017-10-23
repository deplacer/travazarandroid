package com.travazar.tour.packages.util;

import android.content.Context;
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
}
