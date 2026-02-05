package com.example.StudentRegistrationSystem.stalls.repository;

import com.example.StudentRegistrationSystem.stalls.model.Stall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StallRepository extends JpaRepository<Stall, Long> {
}
