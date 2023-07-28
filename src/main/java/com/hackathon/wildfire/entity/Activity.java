package com.hackathon.wildfire.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Builder;
import lombok.Data;
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
@TypeDef(name = "json", typeClass = JsonStringType.class)
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

    @Type(type = "json")
    @Column(columnDefinition = "json")
    Map<String, String> eventMetaData = new HashMap<>();
}
