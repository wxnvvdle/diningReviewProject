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
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String city;

    private String peanut;

    private String egg;

    private String diary;

    public Restaurant(String name,String city, String peanut, String egg, String diary) {
        this.name = name;
        this.city = city;
        this.peanut = peanut;
        this.egg = egg;
        this.diary = diary;
    }
}