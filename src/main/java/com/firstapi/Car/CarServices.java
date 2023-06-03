package com.firstapi.Car;

import com.firstapi.Exceptions.DublicateResourceException;
import com.firstapi.Exceptions.NotValidResourceException;
import com.firstapi.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServices {
    private final CarDAO carDao;

    public CarServices(@Qualifier("Jpa") CarDAO carDao) {
        this.carDao = carDao;
    }


    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    public Car getSingleCars(String regnumber) {

        return carDao.getSingleCars(regnumber).
                orElseThrow(() -> new ResourceNotFoundException("car with  reg number [%s] not found"));
    }

    public List<Car> getElectricCars() {
        return carDao.getElectricCars();
    }

    public void addCar(CarRegistrationRequest carRegistrationRequest) {
        if(carRegistrationRequest.regNumber() == null || carRegistrationRequest.rentalPricePerDay() == null || carRegistrationRequest.brand() == null || Boolean.valueOf(carRegistrationRequest.isElectric()) == null) {
            throw new NotValidResourceException("Missing data");
        }
        String regNumber = carRegistrationRequest.regNumber();
        if (carDao.existsCarWithRegNumber(regNumber)) {
            throw new DublicateResourceException("Car with Register Number [%s] is already exist".
                    formatted(regNumber));
        }
        Car car=new Car(
                carRegistrationRequest.regNumber(),
                carRegistrationRequest.rentalPricePerDay(),
                carRegistrationRequest.brand(),
                carRegistrationRequest.isElectric());
        carDao.addCar(car);
    }
    public List<Car> getAvailableCars() {
        return carDao.getAvailableCars();
    }
    public void deleteCarById(Integer carId) {
        if(!carDao.existsCarWithId(carId)){
            throw new ResourceNotFoundException("Car with ID [%s] not Found");
        }
        carDao.deleteCarById(carId);
    }
}
