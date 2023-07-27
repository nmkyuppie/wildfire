package com.hackathon.wildfire.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column
    String name;
}
