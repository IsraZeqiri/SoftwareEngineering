package com.example.softwareengineering.pojo;


import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userid;
    @Column(name = "username")

    private String username;
    @Column(name = "email")

    private String email;
    @Column(name = "password")

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Event> events;

    //constructor

    public User(Long userid, String username, String email, String password, List<Event> events) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.events = events;
    }

    //default constructor
    public User() {
    }
// getters and setters


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", events=" + events +
                '}';
    }
}
