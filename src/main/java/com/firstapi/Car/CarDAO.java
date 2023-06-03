package com.firstapi.Car;
import java.util.List;
import java.util.Optional;

public interface CarDAO {
      List<Car> getAllCars();
      List<Car> getElectricCars();
      Optional<Car> getSingleCars(String regnumber);
      boolean existsCarWithRegNumber(String regNumber);
      boolean existsCarWithId(Integer id);
      void addCar (Car car);
      List<Car> getAvailableCars();

      void deleteCarById(Integer carId);

}
