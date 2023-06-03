package com.firstapi.Booking;

import com.firstapi.Car.Car;
import com.firstapi.User.Userr;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository

public class CarBookingJPADataAccessService implements CarBookingDAO{
    private final CarBookingRepository carbookingRepository;

    public CarBookingJPADataAccessService(CarBookingRepository carbookingRepository) {
        this.carbookingRepository = carbookingRepository;
    }
    public List<CarBooking> getAll() {
        return carbookingRepository.findAll();
    }
    @Override
    public void add(CarBooking booking) {
        carbookingRepository.save(booking);
    }

    @Override
    public Optional<CarBooking> getById(Integer id) {
        return carbookingRepository.findById(id);
    }


    @Override
    public boolean existsByCar(Car car) {
        return carbookingRepository.existsByCar(car);
    }
}
