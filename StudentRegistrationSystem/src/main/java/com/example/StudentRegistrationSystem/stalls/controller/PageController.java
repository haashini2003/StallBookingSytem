package com.example.StudentRegistrationSystem.stalls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Home page
    @GetMapping("/")
    public String home() {
        return "index"; // index.html
    }

    // How to Book Page
    @GetMapping("/how-to-book")
    public String howToBook() {
        return "how-to-book"; // how-to-book.html
    }

    // ❌  myBookings() method REMOVE pannirukkome – inga illa

    // About page (optional)
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
