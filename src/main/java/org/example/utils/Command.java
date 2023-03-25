package org.example.utils;


import lombok.Value;

import java.util.HashMap;
import java.util.Map;

public class Command {
    Action action;
    Map<String, Integer> params;

    public Command(String action) {
        this.action = Action.valueOf(action);
        params = null;
    }

    public Command(String action, String apartmentType, String corporationWaterRatio, String boreWellWaterRatio) {
        this.action = Action.valueOf(action);
        params = new HashMap<>();
        params.put("apartmentSize", Integer.valueOf(apartmentType));
        params.put("corporationWaterRatio", Integer.valueOf(corporationWaterRatio));
        params.put("boreWaterRatio", Integer.valueOf(boreWellWaterRatio));
    }

    public Command(String action, String numberOfGuests) {
        this.action = Action.valueOf(action);
        params = new HashMap<>();
        params.put("numberOfGuests", Integer.valueOf(numberOfGuests));
    }

    public static Command of(String action) {
        return new Command(action);
    }

    public Action getAction() {
        return action;
    }
    public Integer getApartmentSize() {
        return params.get("apartmentSize");
    }

    public Integer getCorporationWaterRatio() {
        return params.get("corporationWaterRatio");
    }

    public Integer getBoreWaterRatio() {
        return params.get("boreWaterRatio");
    }

    public Integer getNumberOfGuests() {
        return params.get("numberOfGuests");
    }

    public enum Action {
        ALLOT_WATER,
        ADD_GUESTS,
        BILL;
    }
}
