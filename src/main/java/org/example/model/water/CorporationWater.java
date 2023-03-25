package org.example.model.water;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CorporationWater implements Water {
    private static final BigDecimal COST_PER_LITER = BigDecimal.ONE;
    Integer quantity;

    public CorporationWater(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public BigDecimal totalCost() {
        return COST_PER_LITER.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public static Water of(Integer quantity) {
        return new CorporationWater(quantity);
    }
}
