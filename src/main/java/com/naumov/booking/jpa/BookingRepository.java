package com.naumov.booking.jpa;

import com.naumov.booking.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface is automatically implemented by Spring.
 * All methods logic will be created based on their names.
 */
@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Long> {
    List<HotelBooking> findByPricePerNightLessThan(double value);
}
