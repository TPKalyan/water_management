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

        apartment.allotCorporationWater(CorporationWater.of(Math.round(ratioPortion * corporationWaterRatio)));
        apartment.allotBoreWellWater(BoreWellWater.of(Math.round(ratioPortion * boreWaterRatio)));

        return apartment;
    }

    public Apartment allotTankerWater(Apartment apartment, Integer numberOfGuests) {
        Water tankerWater = TankerWater.of(calculateWaterNeededPerMonthFor(numberOfGuests));
        apartment.allotTankerWater(tankerWater);
        return apartment;
    }
}
