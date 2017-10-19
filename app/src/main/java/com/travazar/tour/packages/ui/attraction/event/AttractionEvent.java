/*
 * Copyright (c) 2017.
 * Created by Joseph Mangmang on 10/19/17 3:42 PM
 */

package com.travazar.tour.packages.ui.attraction.event;

import com.travazar.tour.packages.data.model.Attraction;

/**
 * Created by kali_root on 10/18/2017.
 */

public class AttractionEvent {
    public final Attraction attraction;

    public AttractionEvent(Attraction attraction) {
        this.attraction = attraction;
    }
}
