package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @GeneratedValue
    @Id
    private Long id;

    private String userName;

    private String city;

    private String state;

    private Integer zipcode;

    private Boolean peanutInterested;

    private Boolean eggInterested;

    private Boolean diaryInterested;

    public User(String userName, String city, String state, Integer zipcode, Boolean peanutInterested, Boolean eggInterested, Boolean diaryInterested) {
        this.userName = userName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.peanutInterested = peanutInterested;
        this.eggInterested = eggInterested;
        this.diaryInterested = diaryInterested;
    }
}
