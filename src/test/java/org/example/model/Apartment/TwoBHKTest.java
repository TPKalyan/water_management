package org.example.model.Apartment;

import org.example.water.BoreWellWater;
import org.example.water.CorporationWater;
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

    @Test
    void shouldAllotTankWaterWhenGuestsAreAdded() {
        twoBHK = new TwoBHK();

        twoBHK.addGuest(5);

        assertThat(twoBHK.getTotalWaterUsed()).isEqualTo(1500);
        assertThat(twoBHK.getBillPerMonth()).isEqualTo(BigDecimal.valueOf(4500));
    }
}