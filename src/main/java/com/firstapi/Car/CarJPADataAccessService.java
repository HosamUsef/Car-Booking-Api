package com.firstapi.Car;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("Jpa")
public class CarJPADataAccessService implements CarDAO{

    private final CarRepository carRepository;

    public CarJPADataAccessService(CarRepository carRespository) {
        this.carRepository = carRespository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getElectricCars() {
        return carRepository.findAll().stream()
                .filter(c -> !c.isBooked() && c.isElectric())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Car> getSingleCars(String regNumber) {
        return carRepository.findFirstByRegNumber(regNumber);
    }

    @Override
    public boolean existsCarWithRegNumber(String regNumber) {
        return carRepository.existsCarByRegNumber(regNumber);
    }

    @Override
    public boolean existsCarWithId(Integer id) {
        return carRepository.existsCarById(id);
    }

    public List<Car> getAvailableCars() {
        //try with jpa;

        return carRepository.findAll().stream()
                .filter(c -> !c.isBooked())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCarById(Integer carId) {
        carRepository.deleteById(carId);
    }


    @Override public void addCar(Car car) {
        carRepository.save(car);
    }
}
