package model.water;

import model.water.TankerWater;
import model.water.Water;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TankerWaterTest {
    public static Stream<Arguments> getSlabs() {
        return Stream.of(
                Arguments.of("First slab", 300, BigDecimal.valueOf(300)),
                Arguments.of("Second slab", 721, BigDecimal.valueOf(2163)),
                Arguments.of("Third slab", 1895, BigDecimal.valueOf(9475)),
                Arguments.of("Fourth slab", 3054, BigDecimal.valueOf(24432))
        );
    }

    @ParameterizedTest
    @MethodSource("getSlabs")
    public void shouldCalculateBillFor(String name, Integer quantity, BigDecimal totalCost) {
        Water tankWater = TankerWater.of(quantity);
        assertThat(tankWater.totalCost()).isEqualTo(totalCost);
    }
}