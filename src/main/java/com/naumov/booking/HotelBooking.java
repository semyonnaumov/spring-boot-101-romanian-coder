package com.naumov.booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String hotelName;
    private double pricePerNight;
    private int nbOfNights;

    /*
        Default constructor must exist for Spring to be able to instantiate this class when receiving
        json and trying to deserialize it into this class via @ResponseBody annotation
    */
    public HotelBooking(){
    }

    public HotelBooking(String hotelName, double pricePerNight, int nbOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNights = nbOfNights;
    }

    public long getId() {
        return id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNbOfNights() {
        return nbOfNights;
    }

    public double getTotalPrice() {
        return pricePerNight * nbOfNights;
    }
}
