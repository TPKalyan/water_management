package model.Apartment;

import model.water.Water;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Apartment {
    protected final List<Water> allottedWater;
    protected int peopleLiving;

    protected Apartment(int peopleLiving) {
        this.peopleLiving = peopleLiving;
        allottedWater = new ArrayList<>();
    }


    public void addGuest(int numberOfGuests) {
        this.peopleLiving += numberOfGuests;
    }

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
