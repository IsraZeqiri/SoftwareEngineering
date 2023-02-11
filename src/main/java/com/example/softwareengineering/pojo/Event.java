package com.example.softwareengineering.pojo;


import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "location")
    private String location;
    @Column(name = "dateTime")
    private LocalDateTime dateTime;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "price")
    private double price;
    // Add getters and setters
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //constructor

    public Event(Long id, String name, String category, String location, LocalDateTime dateTime, double latitude, double longitude, double price, User user) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.location = location;
        this.dateTime = dateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.user = user;
    }

    public Event(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                ", dateTime=" + dateTime +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
