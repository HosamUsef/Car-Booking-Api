package com.firstapi.Booking;

import com.firstapi.Car.Car;
import com.firstapi.User.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarBookingRepository extends JpaRepository
        <CarBooking,Integer> {

    boolean existsByCar(Car car);
}
