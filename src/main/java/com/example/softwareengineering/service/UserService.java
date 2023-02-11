package com.example.softwareengineering.service;


import com.example.softwareengineering.pojo.Event;
import com.example.softwareengineering.pojo.User;
import com.example.softwareengineering.repository.EventRepository;
import com.example.softwareengineering.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public UserService(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public User updateUser(User updatedUser) {
        User user = userRepository.findById(updatedUser.getUserid()).get();
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void addEvent(Event event, User user) {
        event.setUser(user);
        event.setLatitude(event.getLatitude());
        event.setLongitude(event.getLongitude());
        eventRepository.save(event);
    }
    public List<Event> findEventsByCategory(String category) {
        return eventRepository.findByCategory(category);
    }

    public List<Event> findEventsByLocation(String location) {
        return eventRepository.findByLocation(location);
    }

    public List<Event> findEventsByUser(User user) {
        return eventRepository.findByUser(user);
    }

    public List<Event> findEventsNearLocation(double userLat, double userLng, double radius) {
        return eventRepository.findEventsNearLocation(userLat, userLng, radius);
    }

}

