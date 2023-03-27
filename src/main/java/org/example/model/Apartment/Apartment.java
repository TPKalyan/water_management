package org.example.model.apartment;


import org.example.model.water.TankerWater;
import org.example.model.water.Water;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Apartment {
    private final List<Water> allottedWater;

    protected Apartment() {
        allottedWater = new ArrayList<>();
    }

    public abstract int getWaterNeededPerMonth();

    public void allotWater(Water water) {
        this.allottedWater.add(water);
    }

    public BigDecimal getBillPerMonth() {
        return allottedWater.stream().map(Water::totalCost).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public Integer getTotalWaterUsed() {
        return allottedWater.stream().map(Water::getQuantity).reduce(Integer::sum).orElse(0);
    }
}
