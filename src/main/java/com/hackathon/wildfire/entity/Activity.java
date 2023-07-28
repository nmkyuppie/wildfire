package com.hackathon.wildfire.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Builder
@Data
@TypeDef(name = "jsonb", typeClass = JsonType.class)
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue
    long id;

    @Column
    String appId;

    @Column
    String userId;

    @Column
    String eventId;

    @Column
    LocalDateTime eventOccurredOn;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @JsonProperty("eventMetaData")
    @JsonAnyGetter
    Map<String, String> eventMetaData = new HashMap<>();
}
