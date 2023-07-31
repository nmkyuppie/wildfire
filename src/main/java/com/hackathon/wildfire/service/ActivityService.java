package com.hackathon.wildfire.service;

import com.hackathon.wildfire.constants.EventHappened;
import com.hackathon.wildfire.domain.ActivityResponse;
import com.hackathon.wildfire.entity.Activity;
import com.hackathon.wildfire.repository.ActivityRepository;
import com.hackathon.wildfire.utils.ActivityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> getAllActivity() {
        return activityRepository.findAll();
    }

    public List<ActivityResponse> activityPrediction(String userId) {
        List<ActivityResponse> activityResponses = new ArrayList<>();
        AtomicLong counter = new AtomicLong(1L);
        List<Activity> activities = activityRepository.findAllByUserId(userId);
        // Group by events
        Map<String, List<Activity>> eventGroups = activities.stream().collect(Collectors.groupingBy(Activity::getEventId));
        // Group by metadata
        log.info("Event groups: {}", eventGroups);
        eventGroups.forEach((event, activitiesByEvent) -> {
            log.info("------------------------------------------------------------------------------");
            log.info("Event : {}", event);
            //Date intervals
            Collections.sort(activitiesByEvent, Comparator.comparing(Activity::getEventOccurredOn));
            List<LocalDateTime> eventDates = activitiesByEvent.stream().map(Activity::getEventOccurredOn).collect(Collectors.toList());
            log.info("Event dates: {}", eventDates);
            Map<String, LocalDateTime> processedEventDates = processIntervals(eventDates);
            log.info("Prediction: {}", processedEventDates.get("nextHappeningOn"));
            ActivityResponse activityResponse = ActivityResponse.builder()
                    .appId(activitiesByEvent.get(0).getAppId())
                    .userId(userId)
                    .eventId(event)
                    .nextHappeningOn(processedEventDates.get("nextHappeningOn"))
                    .eventMetaData(activitiesByEvent
                            .stream()
                            .filter(ae -> ae.getEventOccurredOn().equals(processedEventDates.get("lastHappenedOn")))
                            .findFirst()
                            .get()
                            .getEventMetaData())
                    .build();
            activityResponses.add(activityResponse);
        });
        Collections.reverse(activityResponses);
        return activityResponses.stream()
                .sorted(Comparator.comparing(ActivityResponse::getNextHappeningOn))
                .map(ac -> {
                    ac.setRank(counter.getAndIncrement());
                    return ac;
                }).collect(Collectors.toList());
    }

    private Map<String, LocalDateTime> processIntervals(List<LocalDateTime> eventDates) {
        Map<EventHappened, LocalDateTime> prediction = new HashMap<>();
        Map<EventHappened, Integer> frequencyOfEvents = new HashMap<>();
        for (int i = 0; i < eventDates.size() - 1; i++) {
            long differences = eventDates.get(i).until(eventDates.get(i + 1), ChronoUnit.DAYS);
            EventHappened eventHappened = ActivityUtils.eventMode(differences);
            log.info("{} : {} = {} => {}", eventDates.get(i), eventDates.get(i + 1), differences, eventHappened);
            frequencyOfEvents = frequencyCheck(frequencyOfEvents, eventHappened);
            prediction = predictionCheck(prediction, eventHappened, eventDates.get(i + 1));
        }
        EventHappened eventHappened = getMaximumOccurrence(frequencyOfEvents).getKey();
        LocalDateTime lastHappenedOn = prediction.get(eventHappened);
        LocalDateTime nextHappeningOn = ActivityUtils.calculateNextHappening(eventHappened, lastHappenedOn);
        Map<String, LocalDateTime> processedEventDates = new HashMap<>();
        processedEventDates.put("lastHappenedOn", lastHappenedOn);
        processedEventDates.put("nextHappeningOn", nextHappeningOn);
        return processedEventDates;
    }

    private Map<EventHappened, Integer> frequencyCheck(Map<EventHappened, Integer> frequencyOfEvents, EventHappened eventHappened) {
        if (frequencyOfEvents.containsKey(eventHappened)) {
            Integer count = frequencyOfEvents.get(eventHappened);
            frequencyOfEvents.put(eventHappened, ++count);
        } else {
            frequencyOfEvents.put(eventHappened, 1);
        }
        return frequencyOfEvents;
    }

    private Map<EventHappened, LocalDateTime> predictionCheck(Map<EventHappened, LocalDateTime> prediction, EventHappened eventHappened, LocalDateTime newDate) {
        if (prediction.containsKey(eventHappened)) {
            LocalDateTime prevLatestDate = prediction.get(eventHappened);
            prediction.put(eventHappened, prevLatestDate.isAfter(newDate) ? prevLatestDate : newDate);
        } else {
            prediction.put(eventHappened, newDate);
        }
        return prediction;
    }

    private Map.Entry<EventHappened, Integer> getMaximumOccurrence(Map<EventHappened, Integer> frequencyOfEvents) {
        return frequencyOfEvents.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue)).get();

    }
}
