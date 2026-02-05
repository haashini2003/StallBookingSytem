package com.example.StudentRegistrationSystem.config;

import com.example.StudentRegistrationSystem.stalls.model.Stall;
import com.example.StudentRegistrationSystem.stalls.repository.StallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StallRepository stallRepository;

    @Override
    public void run(String... args) throws Exception {
        loadStallsData();
    }

    private void loadStallsData() {
        // DB-la already stalls irundha, duplicate add panna koodadhu
        if (stallRepository.count() == 0) {
            System.out.println("🚀 Loading sample stalls data...");

            List<Stall> stalls = Arrays.asList(
                    createStall(1L, "Food Stall", "Food & Beverages",
                            "Delicious snacks, beverages, and fast food items. Perfect for campus events and festivals.",
                            "Main Ground - Area A", 100, BigDecimal.valueOf(1500.00), "09:00", "21:00", true),

                    createStall(2L, "Book Stall", "Education",
                            "Academic books, novels, stationery, and educational materials for students.",
                            "Library Block - First Floor", 60, BigDecimal.valueOf(800.00), "10:00", "18:00", true),

                    createStall(3L, "Tech Gadgets", "Technology",
                            "Latest mobile accessories, headphones, smartwatches, and electronic gadgets.",
                            "Tech Zone - Block B", 50, BigDecimal.valueOf(1800.00), "10:00", "19:00", true),

                    createStall(4L, "Clothing Store", "Fashion",
                            "Trendy clothes, accessories, and fashion items for students and staff.",
                            "Shopping Complex - Ground Floor", 80, BigDecimal.valueOf(1200.00), "09:00", "20:00", true),

                    createStall(5L, "Art & Crafts", "Arts",
                            "Handmade crafts, paintings, art supplies, and creative workshop materials.",
                            "Arts Block - Room 101", 40, BigDecimal.valueOf(900.00), "10:00", "17:00", true),

                    createStall(6L, "Sports Equipment", "Sports",
                            "Sports gear, fitness equipment, team jerseys, and outdoor activity items.",
                            "Sports Complex - Store 1", 70, BigDecimal.valueOf(1100.00), "08:00", "19:00", true),

                    createStall(7L, "Coffee Corner", "Food & Beverages",
                            "Premium coffee, tea, pastries, and light snacks in a cozy atmosphere.",
                            "Central Cafeteria", 30, BigDecimal.valueOf(2000.00), "08:00", "22:00", true),

                    createStall(8L, "Stationery Hub", "Education",
                            "Complete range of stationery items, notebooks, pens, and office supplies.",
                            "Academic Block - Ground Floor", 45, BigDecimal.valueOf(700.00), "09:00", "18:00", true),

                    createStall(9L, "Photography", "Services",
                            "Photography services, camera rentals, photo printing, and event coverage.",
                            "Media Center", 25, BigDecimal.valueOf(2500.00), "10:00", "19:00", true),

                    createStall(10L, "Health & Wellness", "Health",
                            "Health products, supplements, yoga mats, and wellness services.",
                            "Health Center Annex", 35, BigDecimal.valueOf(1300.00), "09:00", "17:00", true)
            );

            stallRepository.saveAll(stalls);
            System.out.println("✅ Successfully loaded " + stalls.size() + " sample stalls!");
        } else {
            System.out.println("📊 Database already contains " + stallRepository.count() + " stalls.");
        }
    }

    private Stall createStall(Long id, String name, String category, String description,
                              String location, Integer capacity, BigDecimal pricePerHour,
                              String availableFrom, String availableTo, Boolean available) {

        Stall stall = new Stall();
        stall.setId(id);
        stall.setName(name);
        stall.setCategory(category);
        stall.setDescription(description);
        stall.setLocation(location);
        stall.setCapacity(capacity);
        stall.setPricePerHour(pricePerHour);
        stall.setAvailableFrom(availableFrom);
        stall.setAvailableTo(availableTo);
        stall.setIsAvailable(available);
        return stall;
    }
}
