package com.example.StudentRegistrationSystem.stalls.controller;

import com.example.StudentRegistrationSystem.stalls.model.StallBooking;
import com.example.StudentRegistrationSystem.stalls.service.StallBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final StallBookingService bookingService;

    public AdminController(StallBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        List<StallBooking> all = bookingService.getAllBookings();
        model.addAttribute("bookings", all);
        model.addAttribute("totalBookings", all.size());
        model.addAttribute("pageTitle", "Admin Dashboard");
        return "admin-dashboard";
    }

    @GetMapping("/bookings/{id}/edit")
    public String editBookingForm(@PathVariable Long id, Model model) {
        StallBooking booking = bookingService.getBookingById(id);
        if (booking == null) {
            return "redirect:/admin/dashboard";
        }
        model.addAttribute("booking", booking);
        model.addAttribute("pageTitle", "Edit Booking");
        return "admin-booking-edit";
    }

    @PostMapping("/bookings/{id}/update")
    public String updateBooking(@PathVariable Long id,
                                @ModelAttribute("booking") StallBooking formBooking) {

        StallBooking existing = bookingService.getBookingById(id);
        if (existing != null) {
            existing.setDate(formBooking.getDate());
            existing.setStartTime(formBooking.getStartTime());
            existing.setEndTime(formBooking.getEndTime());
            existing.setStatus(formBooking.getStatus());
            existing.setTotalPrice(formBooking.getTotalPrice());
            existing.setBookedBy(formBooking.getBookedBy());

            bookingService.saveBooking(existing);
        }

        return "redirect:/admin/dashboard";
    }

    @PostMapping("/bookings/{id}/delete")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "redirect:/admin/dashboard";
    }
}
