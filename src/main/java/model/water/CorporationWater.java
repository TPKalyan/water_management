package model.water;

import java.math.BigDecimal;

public class CorporationWater implements Water {
    private static final BigDecimal COST_PER_LITER = BigDecimal.ONE;
    private final Integer quantity;

    public CorporationWater(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public BigDecimal totalCost() {
        return COST_PER_LITER.multiply(BigDecimal.valueOf(quantity));
    }

    public static Water of(Integer quantity) {
        return new CorporationWater(quantity);
    }
}
