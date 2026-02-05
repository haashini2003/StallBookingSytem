package com.example.StudentRegistrationSystem.stalls.service;

import com.example.StudentRegistrationSystem.stalls.model.Stall;
import com.example.StudentRegistrationSystem.stalls.repository.StallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StallService {

    private final StallRepository stallRepository;

    public StallService(StallRepository stallRepository) {
        this.stallRepository = stallRepository;
    }

    public List<Stall> getAllStalls() {
        return stallRepository.findAll();
    }

}
