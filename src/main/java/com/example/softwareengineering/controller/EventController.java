package com.example.softwareengineering.controller;


import com.example.softwareengineering.pojo.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
    @GetMapping("/location/{location}")
    public List<Event> findByLocation(@PathVariable String location) {
        return eventService.findByLocation(location);
    }

    @GetMapping("/category/{category}")
    public List<Event> findByCategory(@PathVariable String category) {
        return eventService.findByCategory(category);
    }

    @GetMapping("/daterange")
    public List<Event> findByDateRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        return eventService.findByDateRange(start, end);
    }
}

//    @GetMapping("/nearby")
//    public List<Event> searchEventsNearLocation(@RequestParam double latitude, @RequestParam double longitude, @RequestParam int radius) {
//        return eventService.searchEventsNearLocation(latitude, longitude, radius);
//    }
