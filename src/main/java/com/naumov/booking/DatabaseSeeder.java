package com.naumov.booking;

import com.naumov.booking.jpa.BookingRepository;
import com.naumov.booking.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<HotelBooking> hotelBookings = new ArrayList<>();
        hotelBookings.add(new HotelBooking("Marriot", 220.5, 3));
        hotelBookings.add(new HotelBooking("Ibis", 100.5, 5));
        hotelBookings.add(new HotelBooking("Novotel", 140.3, 1));
        bookingRepository.saveAll(hotelBookings);
    }
}
