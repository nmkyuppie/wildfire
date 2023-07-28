package com.hackathon.wildfire.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class ActivityResponse {

    String appId;
    String userId;
    String eventId;
    Long rank;
    LocalDateTime nextHappeningOn;
    Map<String, String> eventMetaData = new HashMap<>();
}
