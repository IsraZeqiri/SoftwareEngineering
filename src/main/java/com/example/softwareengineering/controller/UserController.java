package com.example.softwareengineering.controller;


import com.example.events.service.UserService;
import com.example.softwareengineering.pojo.Event;
import com.example.softwareengineering.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(updatedUser);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/{username}/events")
    public List<Event> findEventsByUser(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return userService.findEventsByUser(user);
    }

    @PostMapping("/{username}/events")
    public void addEvent(@PathVariable String username, @RequestBody Event event) {
        User user = userService.findByUsername(username);
        userService.addEvent(event, user);
    }
    @GetMapping("/events/category/{category}")
    public List<Event> findEventsByCategory(@PathVariable String category) {
        return userService.findEventsByCategory(category);
    }

    @GetMapping("/events/location/{location}")
    public List<Event> findEventsByLocation(@PathVariable String location) {
        return userService.findEventsByLocation(location);
    }

    @GetMapping("/events/near")
    public List<Event> findEventsNearLocation(@RequestParam double userLat, @RequestParam double userLng, @RequestParam double radius) {
        return userService.findEventsNearLocation(userLat, userLng, radius);
    }

}
