package com.example.demo.repositories;

import com.example.demo.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
    Optional<Restaurant> findByName(String name);

}
