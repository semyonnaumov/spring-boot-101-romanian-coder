package com.naumov.booking.controller;

import com.naumov.booking.jpa.BookingRepository;
import com.naumov.booking.model.HotelBooking;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
@Api(
        name = "Hotel booking API",
        description = "Provides a list of methods that manage hotel bookings",
        stage = ApiStage.BETA
)
public class BookingController {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all bookings from the database")
    public List<HotelBooking>  getAll() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{p}", method = RequestMethod.GET)
    @ApiMethod(description = "Get all affordable bookings from the database")
    public List<HotelBooking>  getAffordable(@ApiPathParam(name = "price") @PathVariable(name = "p") double price) {
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create a hotel booking and save it in the DB")
    public List<HotelBooking> create(@RequestBody HotelBooking newBooking) {
        bookingRepository.save(newBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Remove the hotel booking from the DB")
    public List<HotelBooking> remove(@ApiPathParam(name = "id") @PathVariable long id) {
        bookingRepository.deleteById(id);
        return  bookingRepository.findAll();
    }
}
