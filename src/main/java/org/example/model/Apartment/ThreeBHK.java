package org.example.model.apartment;

import org.example.utils.WaterUtils;

public class ThreeBHK extends Apartment {
    private static final int PEOPLE_LIVING = 5;

    public ThreeBHK() {
        super(PEOPLE_LIVING);
    }

    @Override
    public int getWaterNeededPerMonth() {
        return WaterUtils.calculateWaterNeededPerMonthFor(PEOPLE_LIVING);
    }
}
