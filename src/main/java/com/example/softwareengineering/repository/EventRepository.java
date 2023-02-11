package com.example.softwareengineering.repository;

import com.example.softwareengineering.pojo.Event;
import com.example.softwareengineering.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(value = "SELECT *, (6371 * acos(cos(radians(:userLat)) * cos(radians(latitude)) * cos(radians(longitude) - radians(:userLng)) + sin(radians(:userLat)) * sin(radians(latitude)))) AS distance FROM event HAVING distance < :radius ORDER BY distance", nativeQuery = true)
    List<Event> findEventsNearLocation(@Param("userLat") double userLat, @Param("userLng") double userLng, @Param("radius") double radius);
    List<Event> findByLocation(String location);
    List<Event> findByCategory(String category);
    List<Event> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Event> findByUser(User user);

}