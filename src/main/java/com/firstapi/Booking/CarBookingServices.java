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

    //    public void saveNewBooking(CarBooking carBooking) {
//        List<Car> cars = new ArrayList<>();
//        cars = CarArrayDataAccessService.getCars();
//        carBookingDAO.saveBooking(carBooking);
//        System.out.println("Successfully booked car with reg number "
//                + carBooking.getCar().getRegNumber() +
//                " for user " + carBooking.getUser() + "\n" +
//                "Booking ref: " + carBooking.getBookingId());
//        cars.removeIf(o -> o.getRegNumber().equals(carBooking.getCar().getRegNumber()));
//        CarArrayDataAccessService.setCars(cars);
//    }
//
//    public void getAllBookings() {
//        List<CarBooking> carBookings = carBookingDAO.getAllBookings();
//        if (carBookings.size() == 0) {
//            System.out.println("No booking avaliable ☹\uFE0F\n");
//        }
//        carBookings.forEach(System.out::println);
//
//    }
//
//    public void getAllUserBooked(UUID id) {
//        List<CarBooking> carBookings = carBookingDAO.getAllBookings();
//        if (carBookings.isEmpty()) {
//            System.out.println("❌ user " + userServices.getSingleUser(id) + " has no cars booked");
//            return;
//        }
//        for (CarBooking carBooking : carBookings) {
//
//                if (carBooking.getUser().getId().equals(id)) {
//                    System.out.println(carBooking.getUser() + "\n");
//                } else {
//                    System.out.println("❌ user " + userServices.getSingleUser(id) + " has no cars booked");
//                }
//
//
//        }
//    }

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

//        var isCarBooked = carBookingDAO.existsByCar(car);
//        if (isCarBooked) {
//            throw new DublicateResourceException("car is taken");
//        }
        if (car.isBooked()) {
            throw new DublicateResourceException("car is taken");
        }
        car.setBooked(true);
        CarBooking carBooking = new CarBooking(user, car);
        carBookingDAO.add(carBooking);

    }
}
