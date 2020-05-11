package com.naumov.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String hotelName;
    private Double pricePerNight;
    private Integer nbOfNights;

    // JPA needs this
    public HotelBooking(){
    }

    public HotelBooking(String hotelName, Double pricePerNight, Integer nbOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNights = nbOfNights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Integer getNbOfNights() {
        return nbOfNights;
    }

    public void setNbOfNights(Integer nbOfNights) {
        this.nbOfNights = nbOfNights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelBooking booking = (HotelBooking) o;
        return Objects.equals(id, booking.id) &&
                Objects.equals(hotelName, booking.hotelName) &&
                Objects.equals(pricePerNight, booking.pricePerNight) &&
                Objects.equals(nbOfNights, booking.nbOfNights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelName, pricePerNight, nbOfNights);
    }

    @Override
    public String toString() {
        return "HotelBooking{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", nbOfNights=" + nbOfNights +
                '}';
    }
}
