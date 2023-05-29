package com.example.demo.controller;


import com.example.demo.model.Restaurant;
import com.example.demo.repositories.RestaurantRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/{RestaurantName}")
    public Restaurant getRestaurant(@PathVariable String name) {
        Optional<Restaurant>optionalRestaurantToGet = restaurantRepository.findByName(name) ;
        if(!optionalRestaurantToGet.isPresent()){
            return null;
        }
        return optionalRestaurantToGet.get();
    }
    @PostMapping()
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PutMapping("{RestaurantName}")
    public Restaurant editRestaurant(@PathVariable String name, @RequestBody Restaurant restaurant) {
        Optional<Restaurant> optionalRestaurantToUpdate = restaurantRepository.findByName(name);
        if(!optionalRestaurantToUpdate.isPresent()){
            return null;
        }
        Restaurant updatedRestaurant = optionalRestaurantToUpdate.get();
        updatedRestaurant.setName(restaurant.getName());
        updatedRestaurant.setCity(restaurant.getCity());
        updatedRestaurant.setDiary(restaurant.getDiary());
        updatedRestaurant.setEgg(restaurant.getEgg());
        updatedRestaurant.setPeanut(restaurant.getPeanut());
        return updatedRestaurant;
    }
    @DeleteMapping("/{RestaurantName}")
    public Restaurant deleteRestaurant(@PathVariable String name) {
        Optional<Restaurant> restaurantToDeleteOptional = restaurantRepository.findByName(name);
        if(!restaurantToDeleteOptional.isPresent()){
            return null;
        }
        Restaurant restaurantToDelete = restaurantToDeleteOptional.get();
        restaurantRepository.delete(restaurantToDelete);
        return restaurantToDelete;
    }
}
