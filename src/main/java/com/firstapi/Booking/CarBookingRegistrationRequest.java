package com.firstapi.Booking;

import com.firstapi.Car.Car;
import com.firstapi.User.Userr;

public record CarBookingRegistrationRequest (
        Userr user , Car car
){
}
