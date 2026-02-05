package com.example.StudentRegistrationSystem.stalls.repository;

import com.example.StudentRegistrationSystem.stalls.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
