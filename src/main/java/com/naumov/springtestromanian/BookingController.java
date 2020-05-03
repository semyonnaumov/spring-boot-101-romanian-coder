package com.naumov.springtestromanian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking>  getAll() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{p}", method = RequestMethod.GET)
    public List<HotelBooking>  getAffordable(@PathVariable(required = true, name = "p") double price) {
        // name property in @PathVariable is optional when variable name equals name in curly braces {p}
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking newBooking) {
        bookingRepository.save(newBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<HotelBooking> remove(@PathVariable long id) {
        bookingRepository.deleteById(id);
        return  bookingRepository.findAll();
    }
}
