package model.water;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;

public class TankerWater implements Water {
    private final Integer quantity;

    public TankerWater(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public BigDecimal totalCost() {
        return getCostPerLiter().multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    private BigDecimal getCostPerLiter() {
        if (this.quantity <= 500) return ONE;
        if (this.quantity <= 1500) return BigDecimal.valueOf(3);
        if (this.quantity <= 3000) return BigDecimal.valueOf(5);
        return BigDecimal.valueOf(8);
    }

    public static Water of(Integer quantity) {
        return new TankerWater(quantity);
    }
}
