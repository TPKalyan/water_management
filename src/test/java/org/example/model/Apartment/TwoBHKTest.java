package org.example.model.apartment;

import org.example.model.water.BoreWellWater;
import org.example.model.water.CorporationWater;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class TwoBHKTest {

    private TwoBHK twoBHK;

    @Test
    void shouldAllotCorporationWaterAndBoreWater() {
        twoBHK = new TwoBHK();

        twoBHK.allotWater(CorporationWater.of(270));
        twoBHK.allotWater(BoreWellWater.of(630));

        assertThat(twoBHK.getTotalWaterUsed()).isEqualTo(900);
        assertThat(twoBHK.getBillPerMonth()).isEqualTo(BigDecimal.valueOf(1215.0));
    }
}