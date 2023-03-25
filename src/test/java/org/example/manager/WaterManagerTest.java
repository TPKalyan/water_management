package org.example.manager;

import org.example.model.apartment.Apartment;
import org.example.model.water.BoreWellWater;
import org.example.model.water.CorporationWater;
import org.example.model.water.TankerWater;
import org.example.model.water.Water;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class WaterManagerTest {

    private WaterManager waterManager;

    @BeforeEach
    void setUp() {
        waterManager = new WaterManager();
    }

    @Test
    void shouldAllotWaterToApartmentInGivenRatio() {
        Apartment apartment = mock(Apartment.class);
        when(apartment.getWaterNeededPerMonth()).thenReturn(900);

        waterManager.allotWater(apartment, 2, 5);

        verify(apartment).allotCorporationWater(CorporationWater.of(257));
        verify(apartment).allotBoreWellWater(BoreWellWater.of(643));
    }

    @Test
    void shouldAllotTankerWaterToApartment() {
        Apartment apartment = mock(Apartment.class);

        waterManager.allotTankerWater(apartment, 2);

        verify(apartment).allotTankerWater(TankerWater.of(600));
    }
}