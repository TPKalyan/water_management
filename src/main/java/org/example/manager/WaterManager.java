package org.example.manager;

import org.example.model.apartment.Apartment;
import org.example.model.water.BoreWellWater;
import org.example.model.water.CorporationWater;

public class WaterManager {
    public Apartment allotWater(Apartment apartment, Integer corporationWaterRatio, Integer boreWaterRatio) {
        float ratioPortion = ((float) apartment.getWaterNeededPerMonth()) / (corporationWaterRatio + boreWaterRatio);

        apartment.allotWater(CorporationWater.of(Math.round(ratioPortion * corporationWaterRatio)));
        apartment.allotWater(BoreWellWater.of(Math.round(ratioPortion * boreWaterRatio)));

        return apartment;
    }
}
