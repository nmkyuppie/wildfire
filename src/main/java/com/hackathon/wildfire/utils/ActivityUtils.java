package com.hackathon.wildfire.utils;

import com.hackathon.wildfire.constants.EventHappened;
import com.hackathon.wildfire.constants.PredictorConstants;

import java.time.LocalDateTime;

public class ActivityUtils {

    public static EventHappened eventMode(Long days) {
        if (PredictorConstants.YEARLY.contains(days)) {
            return EventHappened.YEARLY;
        } else if (PredictorConstants.HALF_YEARLY.contains(days)) {
            return EventHappened.HALF_YEARLY;
        } else if (PredictorConstants.QUARTERLY.contains(days)) {
            return EventHappened.QUARTERLY;
        } else if (PredictorConstants.MONTHLY.contains(days)) {
            return EventHappened.MONTHLY;
        } else if (PredictorConstants.BI_MONTHLY.contains(days)) {
            return EventHappened.BI_MONTHLY;
        } else if (PredictorConstants.DAILY.contains(days)) {
            return EventHappened.DAILY;
        } else {
            return EventHappened.NA;
        }
    }

    public static LocalDateTime calculateNextHappening(EventHappened eventHappened, LocalDateTime lastHappenedOn) {
        if (eventHappened.equals(EventHappened.YEARLY)) {
            return lastHappenedOn.plusYears(1);
        } else if (eventHappened.equals(EventHappened.HALF_YEARLY)) {
            return lastHappenedOn.plusMonths(6);
        } else if (eventHappened.equals(EventHappened.QUARTERLY)) {
            return lastHappenedOn.plusMonths(3);
        } else if (eventHappened.equals(EventHappened.MONTHLY)) {
            return lastHappenedOn.plusMonths(1);
        } else if (eventHappened.equals(EventHappened.BI_MONTHLY)) {
            return lastHappenedOn.plusDays(15);
        } else if (eventHappened.equals(EventHappened.DAILY)) {
            return lastHappenedOn.plusMonths(1);
        } else {
            return lastHappenedOn;
        }
    }
}
