package org.example.model.apartment;


import org.example.model.water.TankerWater;
import org.example.model.water.Water;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.example.model.apartment.WaterType.BORE_WELL_WATER;
import static org.example.model.apartment.WaterType.CORPORATION_WATER;
import static org.example.model.apartment.WaterType.TANKER_WATER;

public abstract class Apartment {
    private final Map<WaterType, Water> allottedWater;

    protected Apartment() {
        allottedWater = new HashMap<>();
    }

    public abstract int getWaterNeededPerMonth();

    public void allotCorporationWater(Water water) {
        allottedWater.put(CORPORATION_WATER, water);
    }

    public void allotBoreWellWater(Water water) {
        allottedWater.put(BORE_WELL_WATER, water);
    }

    public void allotTankerWater(Water water) {
        if(Objects.isNull(allottedWater.get(TANKER_WATER))) {
            allottedWater.put(TANKER_WATER, water);
        } else {
            ((TankerWater) allottedWater.get(TANKER_WATER)).add((TankerWater) water);
        }
    }

    public BigDecimal getBillPerMonth() {
        return allottedWater.values().stream().map(Water::totalCost).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public Integer getTotalWaterUsed() {
        return  allottedWater.values().stream().map(Water::getQuantity).reduce(Integer::sum).orElse(0);
    }
}
