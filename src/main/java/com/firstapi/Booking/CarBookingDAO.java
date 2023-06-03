package com.firstapi.Booking;

import com.firstapi.Car.Car;

import java.util.List;
import java.util.Optional;

public interface CarBookingDAO {
    List<CarBooking> getAll();
    void add(CarBooking booking);

    boolean existsByCar(Car car);

    Optional<CarBooking> getById(Integer id);

}
