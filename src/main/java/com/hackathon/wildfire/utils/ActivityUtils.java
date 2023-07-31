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
        LocalDateTime nextHappeningOn = lastHappenedOn != null ? lastHappenedOn : LocalDateTime.now();
        while (nextHappeningOn.isBefore(LocalDateTime.now())) {
            if (eventHappened.equals(EventHappened.YEARLY)) {
                nextHappeningOn = nextHappeningOn.plusYears(1);
            } else if (eventHappened.equals(EventHappened.HALF_YEARLY)) {
                nextHappeningOn = nextHappeningOn.plusMonths(6);
            } else if (eventHappened.equals(EventHappened.QUARTERLY)) {
                nextHappeningOn = nextHappeningOn.plusMonths(3);
            } else if (eventHappened.equals(EventHappened.MONTHLY)) {
                nextHappeningOn = nextHappeningOn.plusMonths(1);
            } else if (eventHappened.equals(EventHappened.BI_MONTHLY)) {
                nextHappeningOn = nextHappeningOn.plusDays(15);
            } else if (eventHappened.equals(EventHappened.DAILY)) {
                nextHappeningOn = nextHappeningOn.plusMonths(1);
            } else {
                return nextHappeningOn;
            }
        }
        return nextHappeningOn;
    }
}
