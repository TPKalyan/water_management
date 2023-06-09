package org.example.model.water;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class BoreWellWaterTest {

    @Test
    void shouldCalculateTotalCost() {
        int waterUsedInLiters = 300;
        BigDecimal expectedCost = BigDecimal.valueOf(450.0);

        assertThat(BoreWellWater.of(waterUsedInLiters).totalCost()).isEqualTo(expectedCost);
    }

    @Test
    void shouldGetTotalWaterInLiters() {
        int waterUsedInLiters = 300;
        assertThat(BoreWellWater.of(waterUsedInLiters).getQuantity()).isEqualTo(waterUsedInLiters);
    }
}