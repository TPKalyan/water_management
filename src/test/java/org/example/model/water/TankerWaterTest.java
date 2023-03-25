package org.example.model.water;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TankerWaterTest {
    @ParameterizedTest
    @MethodSource("getSlabs")
    public void shouldCalculateBillFor(String name, Integer quantity, BigDecimal totalCost) {
        Water tankWater = TankerWater.of(quantity);
        assertThat(tankWater.totalCost()).isEqualTo(totalCost);
    }

    @Test
    void shouldGetWaterQuantityInLiters() {
        Integer quantity = 250;
        assertThat(TankerWater.of(quantity).getQuantity()).isEqualTo(quantity);
    }

    @Test
    void shouldAddQuantityToTankerWater() {
        TankerWater initialTankerWater = new TankerWater(20);
        TankerWater additionalTankerWater = new TankerWater(30);

        assertThat(initialTankerWater.add(additionalTankerWater).getQuantity()).isEqualTo(50);
    }

    public static Stream<Arguments> getSlabs() {
        return Stream.of(
                Arguments.of("First slab", 300, BigDecimal.valueOf(600)),
                Arguments.of("Second slab", 721, BigDecimal.valueOf(2163)),
                Arguments.of("Third slab", 1895, BigDecimal.valueOf(9475)),
                Arguments.of("Fourth slab", 3054, BigDecimal.valueOf(24432))
        );
    }
}