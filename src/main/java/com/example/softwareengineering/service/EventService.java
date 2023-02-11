package com.example.softwareengineering.service;


import com.example.softwareengineering.pojo.Event;
import com.example.softwareengineering.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }


    public List<Event> findByLocation(String location) {
        return eventRepository.findByLocation(location);
    }

    public List<Event> findByCategory(String category) {
        return eventRepository.findByCategory(category);
    }

    public List<Event> findByDateRange(LocalDateTime start, LocalDateTime end) {
        return eventRepository.findByDateTimeBetween(start, end);
    }
}
