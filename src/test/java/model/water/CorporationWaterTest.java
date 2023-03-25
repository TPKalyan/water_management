package model.water;

import model.water.CorporationWater;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CorporationWaterTest {

    @Test
    void shouldGetTotalQuantity() {
        Integer waterUsedInLiters = 200;
        assertThat(CorporationWater.of(waterUsedInLiters).getQuantity()).isEqualTo(waterUsedInLiters);
    }

    @Test
    void shouldCalculateTotalCost() {
        int waterUsedInLiters = 300;
        BigDecimal expectedCost = BigDecimal.valueOf(300);
        assertThat(CorporationWater.of(waterUsedInLiters).totalCost()).isEqualTo(expectedCost);
    }
}