package com.firstapi.Booking;

import com.firstapi.Car.Brand;
import com.firstapi.Car.Car;
import com.firstapi.User.Userr;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/CarBooking")

public class CarBookingController {
    private final CarBookingServices carBookingServices;

    public CarBookingController(CarBookingServices carBookingServices) {
        this.carBookingServices = carBookingServices;
    }

    @GetMapping
    public List<CarBooking> getBooking(){
     return carBookingServices.getAll();
//        Faker faker = new Faker();
//
//        List<CarBooking> carBookings=new ArrayList<>();
//        Userr user=new Userr(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
//        Userr use2=new Userr(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
//        Car car=new Car("1224", BigDecimal.valueOf(132, 0), Brand.BMW, false,true);
//        CarBooking carBooking=new CarBooking(user,car);
//        CarBooking carBooking2=new CarBooking(use2,car);
//        carBookings.add(carBooking);
//        carBookings.add(carBooking2);
//        return carBookings;
    }

    @GetMapping("{id}")
    public CarBooking getBookingById(@PathVariable("id") Integer id){
        return carBookingServices.getById(id);
    }

    @PostMapping
    public void addBooking(@RequestBody CarBookingRegistrationRequest request){
        carBookingServices.add(request);
    }

}
