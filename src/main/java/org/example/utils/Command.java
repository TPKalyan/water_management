package org.example.utils;


import lombok.Value;

import java.util.Map;

@Value
public class Command {
    Action action;
    Map<String, Integer> params;

    public Integer getApartmentSize() {
        return params.get("apartmentSize");
    }

    public Integer getCorporationWaterRatio() {
        return params.get("corporationWaterRatio");
    }

    public Integer getBoreWaterRatio() {
        return params.get("boreWaterRatio");
    }

    public Integer getGuestSize() {
        return params.get("guestSize");
    }

    public enum Action {
        ALLOT_WATER,
        ADD_GUESTS,
        BILL;
    }
}
