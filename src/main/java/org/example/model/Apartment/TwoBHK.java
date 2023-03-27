package org.example.model.apartment;

import org.example.utils.WaterUtils;

public class TwoBHK extends Apartment{
    private static final int PEOPLE_LIVING = 3;

    public TwoBHK() {
        super();
    }

    @Override
    public int getWaterNeededPerMonth() {
        return WaterUtils.calculateWaterNeededPerMonthFor(PEOPLE_LIVING);
    }
}
