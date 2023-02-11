package com.example.softwareengineering.repository;


import com.example.softwareengineering.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

    Optional<User> findById(Long id);
    // custom methods, if any
}