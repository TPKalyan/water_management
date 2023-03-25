package org.example.manager;

import org.example.model.apartment.Apartment;
import org.example.model.water.BoreWellWater;
import org.example.model.water.CorporationWater;
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
        doNothing().when(apartment).allotWater(any(Water.class));
        when(apartment.getWaterNeededPerMonth()).thenReturn(900);

        waterManager.allotWater(apartment, 2, 5);

        verify(apartment).allotWater(CorporationWater.of(257));
        verify(apartment).allotWater(BoreWellWater.of(643));
    }
}