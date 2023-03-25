package org.example.water;

import java.math.BigDecimal;

public class BoreWellWater implements Water {
    private static final BigDecimal COST_PER_LITER = BigDecimal.valueOf(1.5);
    private final Integer quantity;

    public BoreWellWater(Integer quantity) {
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
        return new BoreWellWater(quantity);
    }
}
