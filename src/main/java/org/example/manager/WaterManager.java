package org.example.manager;

import org.example.model.apartment.Apartment;
import org.example.model.water.BoreWellWater;
import org.example.model.water.CorporationWater;
import org.example.model.water.TankerWater;
import org.example.model.water.Water;

import static org.example.utils.WaterUtils.calculateWaterNeededPerMonthFor;

public class WaterManager {
    public Apartment allotWater(Apartment apartment, Integer corporationWaterRatio, Integer boreWaterRatio) {
        float ratioPortion = ((float) apartment.getWaterNeededPerMonth()) / (corporationWaterRatio + boreWaterRatio);

        apartment.allotWater(CorporationWater.of(Math.round(ratioPortion * corporationWaterRatio)));
        apartment.allotWater(BoreWellWater.of(Math.round(ratioPortion * boreWaterRatio)));

        return apartment;
    }

    public Apartment allotTankerWater(Apartment apartment, Integer numberOfGuests) {
        Water tankerWater = TankerWater.of(calculateWaterNeededPerMonthFor(numberOfGuests));
        apartment.allotWater(tankerWater);
        return apartment;
    }
}
