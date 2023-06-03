package com.firstapi.Car;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarsController {
    private final CarServices carServices;

    public CarsController(CarServices carServices) {
        this.carServices = carServices;
    }
    @GetMapping
    public List<Car> getAllCars(){
        return carServices.getAllCars();
    }

    @GetMapping("/available-electric")
    public List<Car> getElectricCars(){
        return carServices.getElectricCars();
    }
    @GetMapping("/available")
    public List<Car> getAvalaibleCars(){
        return carServices.getAvailableCars();
    }

    @GetMapping("/{regnumber}")
    public Car getSingleCar(
            @PathVariable("regnumber") String reg){
        return carServices.getSingleCars(reg);
    }
    @PostMapping
    public void addCar(
            @RequestBody CarRegistrationRequest request){
        carServices.addCar(request);
    }
    @DeleteMapping("/{carId}")
    public void deleteCarById(@PathVariable("carId") Integer carId){
        carServices.deleteCarById(carId);
    }
}
