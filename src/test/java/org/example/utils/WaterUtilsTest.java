package org.example.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.utils.WaterUtils.calculateWaterNeededPerMonthFor;

class WaterUtilsTest {

    @Test
    void shouldCalculateWaterUsagePerPersonPerMonth() {
        int waterNeeded = calculateWaterNeededPerMonthFor(2);
        assertThat(waterNeeded).isEqualTo(600);
    }

    @Test
    void shouldCalculateTheCorporationWaterAndBoreWellWaterRatio() {

    }
}