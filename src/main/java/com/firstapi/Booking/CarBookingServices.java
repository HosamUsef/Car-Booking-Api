package com.firstapi.Booking;


import com.firstapi.Car.Car;
import com.firstapi.Car.CarDAO;
import com.firstapi.Exceptions.DublicateResourceException;
import com.firstapi.Exceptions.NotValidResourceException;
import com.firstapi.Exceptions.ResourceNotFoundException;
import com.firstapi.User.UserDAO;
import com.firstapi.User.Userr;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CarBookingServices {
    private final CarBookingDAO carBookingDAO;

    private final UserDAO userDAO;
    private final CarDAO carDAO;

    public CarBookingServices(
            CarBookingDAO carBookingDAO,
            @Qualifier("JPA") UserDAO userDAO,
            @Qualifier("Jpa") CarDAO carDAO) {
        this.carBookingDAO = carBookingDAO;
        this.userDAO = userDAO;
        this.carDAO = carDAO;
    }
    public CarBooking getById(Integer id) {
        var booking = carBookingDAO.getById(id);
        return booking.orElseThrow(() ->
                new ResourceNotFoundException("Booking with id [%s] not found".formatted(id))
        );
    }

    public List<CarBooking> getAll() {
        return carBookingDAO.getAll();
    }

    public void add(CarBookingRegistrationRequest request) {
        System.out.println("req: " + request);
        if (request.user() == null || request.car() == null) {
            throw new NotValidResourceException("Missing Data");
        }

        Car car = carDAO.getSingleCars(request.car().getRegNumber()).orElseThrow(
                () -> new ResourceNotFoundException("car with reg %s not found".formatted(request.car().getRegNumber()))
        );
        Userr user = userDAO.getUserById(request.user().getUuid()).orElseThrow(
                () -> new ResourceNotFoundException("user with id %s not found".formatted(request.user().getUuid()))
        );

        if (car.isBooked()) {
            throw new DublicateResourceException("car is taken");
        }
        car.setBooked(true);
        CarBooking carBooking = new CarBooking(user, car);
        carBookingDAO.add(carBooking);

    }
}
