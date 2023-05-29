package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiningReview {

    @Id
    private String reviewer;

    private Optional<Integer> peanutScore;

    private Optional<Integer> eggScore;

    private Optional<Integer> diaryScore;

    private Optional<String> commentary;

    private Status status;


}

