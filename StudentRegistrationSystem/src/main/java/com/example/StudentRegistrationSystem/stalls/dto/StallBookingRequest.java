package com.example.StudentRegistrationSystem.stalls.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StallBookingRequest {

    @NotNull(message = "Stall ID is required")
    private Long stallId;

    @NotBlank(message = "Booked By is required")
    private String bookedBy;

    public Long getStallId() {
        return stallId;
    }

    public void setStallId(Long stallId) {
        this.stallId = stallId;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }
}
