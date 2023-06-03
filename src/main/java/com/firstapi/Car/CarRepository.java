package com.firstapi.Car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Integer> {
boolean existsCarByRegNumber(String regNumber);
Optional<Car> findFirstByRegNumber(String regNumber);

    boolean existsCarById(Integer id);
}
