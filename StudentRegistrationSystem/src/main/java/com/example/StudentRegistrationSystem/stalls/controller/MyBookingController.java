package com.example.StudentRegistrationSystem.stalls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/my-bookings")
public class MyBookingController {

    // Sample data for testing
    private List<Map<String, String>> userBookings;

    public MyBookingController() {
        // Initialize with sample data
        userBookings = new ArrayList<>();

        Map<String, String> booking1 = new HashMap<>();
        booking1.put("id", "1");
        booking1.put("stallName", "Food Stall");
        booking1.put("date", "2025-12-25");
        booking1.put("status", "Confirmed");
        booking1.put("price", "RS1,500.00");
        userBookings.add(booking1);

        Map<String, String> booking2 = new HashMap<>();
        booking2.put("id", "2");
        booking2.put("stallName", "Health & Wellness");
        booking2.put("date", "2025-12-26");
        booking2.put("status", "Pending");
        booking2.put("price", "RS2,600.00");
        userBookings.add(booking2);
    }

    @GetMapping("")
    public String myBookings(Model model) {
        System.out.println("MyBookingController: Loading my-bookings page");
        System.out.println("Number of bookings: " + userBookings.size());

        model.addAttribute("bookings", userBookings);
        model.addAttribute("pageTitle", "My Bookings");

        return "my-booking";  // my-booking.html
    }

    @GetMapping("/{id}")
    public String viewBooking(@PathVariable String id, Model model) {
        System.out.println("Viewing booking ID: " + id);

        // Find booking by ID
        for (Map<String, String> booking : userBookings) {
            if (booking.get("id").equals(id)) {
                model.addAttribute("booking", booking);
                break;
            }
        }

        return "my-booking/view";
    }

    @PostMapping("/{id}/cancel")
    public String cancelBooking(@PathVariable String id) {
        System.out.println("Cancelling booking ID: " + id);

        // Remove booking logic
        userBookings.removeIf(booking -> booking.get("id").equals(id));

        return "redirect:/my-bookings?cancelled=true";
    }

    // Add new booking (for testing)
    @GetMapping("/add-sample")
    public String addSampleBooking() {
        Map<String, String> newBooking = new HashMap<>();
        newBooking.put("id", String.valueOf(userBookings.size() + 1));
        newBooking.put("stallName", "Test Stall");
        newBooking.put("date", "2025-12-27");
        newBooking.put("status", "Confirmed");
        newBooking.put("price", "RS1,000.00");
        userBookings.add(newBooking);

        return "redirect:/my-bookings";
    }
}