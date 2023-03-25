package org.example.model.Apartment;

import org.example.water.TankerWater;
import org.example.water.Water;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Apartment {
    private final List<Water> allottedWater;
    private int peopleLiving;
    private static final int DAYS_IN_MONTH = 30;
    private static final int WATER_NEEDED_PER_PERSON_PER_DAY = 10;

    protected Apartment(int peopleLiving) {
        this.peopleLiving = peopleLiving;
        allottedWater = new ArrayList<>();
    }


    public void addGuest(int numberOfGuests) {
        int waterNeededByGuestsPerMonth = numberOfGuests * DAYS_IN_MONTH * WATER_NEEDED_PER_PERSON_PER_DAY;
        allotWater(TankerWater.of(waterNeededByGuestsPerMonth));
    }

    public void allotWater(Water water) {
        this.allottedWater.add(water);
    }

    public BigDecimal getBillPerMonth() {
        return allottedWater.stream().map(Water::totalCost).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public Integer getTotalWaterUsed() {
        System.out.println(allottedWater);
        return allottedWater.stream().map(Water::getQuantity).reduce(Integer::sum).orElse(0);
    }
}
