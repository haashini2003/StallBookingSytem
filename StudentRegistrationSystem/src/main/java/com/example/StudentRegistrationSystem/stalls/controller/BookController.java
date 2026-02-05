package com.example.StudentRegistrationSystem.stalls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    // General book information page
    @GetMapping("/book")
    public String bookInfo() {
        return "book";  // book.html
    }

    // ❌ Remove if conflicting with StallBookingController
    // @GetMapping("/booking")
    // public String booking() {
    //     return "booking";
    // }
}
