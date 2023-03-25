package org.example.utils;

public class WaterUtils {
    private static final int DAYS_IN_MONTH = 30;
    private static final int WATER_NEEDED_PER_PERSON_PER_DAY = 10;

    public static int calculateWaterNeededPerMonthFor(int numberOfPeople) {
        return numberOfPeople * DAYS_IN_MONTH * WATER_NEEDED_PER_PERSON_PER_DAY;
    }
}
