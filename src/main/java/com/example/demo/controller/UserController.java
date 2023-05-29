package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;



    @GetMapping()
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) {
            return  null;
        }
        User user = userOptional.get();
        return user;
    }

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User user) {
        Optional <User> userOptionalToUpdate = userRepository.findById(id);
         if(!userOptionalToUpdate.isPresent()) {
            return null;
        }
        User userToUpdate = userOptionalToUpdate.get();
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setCity(user.getCity());
        userToUpdate.setState(user.getState());
        userToUpdate.setZipcode(user.getZipcode());
        userToUpdate.setEggInterested(user.getEggInterested());
        userToUpdate.setDiaryInterested(user.getDiaryInterested());
        userToUpdate.setPeanutInterested(user.getPeanutInterested());

          return userRepository.save(userToUpdate);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        Optional<User>OptionalUserToDelete = userRepository.findById(id);
         if(!OptionalUserToDelete.isPresent()) {
            return "Wrong userName.";
        }
        User userToDelete = OptionalUserToDelete.get();
        userRepository.delete(userToDelete);
            return "Success!";
    }










}
