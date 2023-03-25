package org.example.model.apartment;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ThreeBHKTest {

    @Test
    void shouldGetWaterNeededPerMonth() {
        ThreeBHK threeBHK = new ThreeBHK();
        assertThat(threeBHK.getWaterNeededPerMonth()).isEqualTo(1500);
    }
}