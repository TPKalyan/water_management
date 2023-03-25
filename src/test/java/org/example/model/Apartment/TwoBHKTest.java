package org.example.model.Apartment;

import org.example.model.Apartment.TwoBHK;
import org.example.water.BoreWellWater;
import org.example.water.CorporationWater;
import org.example.water.TankerWater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class TwoBHKTest {

    private TwoBHK twoBHK;

    @BeforeEach
    void setUp() {
        twoBHK = new TwoBHK();

        twoBHK.allotWater(CorporationWater.of(270));
        twoBHK.allotWater(BoreWellWater.of(630));
        twoBHK.allotWater(TankerWater.of(600));
        twoBHK.allotWater(TankerWater.of(900));
    }

    @Test
    void shouldCalculateBill() {
        assertThat(twoBHK.getBillPerMonth()).isEqualTo(BigDecimal.valueOf(5215.0));
    }

    @Test
    void shouldGetTotalWaterUsed() {
        assertThat(twoBHK.getTotalWaterUsed()).isEqualTo(2400);
    }
}