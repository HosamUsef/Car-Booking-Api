package com.firstapi;

import com.firstapi.Booking.CarBooking;
import com.firstapi.Booking.CarBookingRepository;
import com.firstapi.Car.Brand;
import com.firstapi.Car.Car;
import com.firstapi.Car.CarRepository;
import com.firstapi.User.UserRepository;
import com.firstapi.User.Userr;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@RestController
public class CarBookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarBookingApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CarRepository carRepository, UserRepository userRepository, CarBookingRepository carBookingRepository) {
		return args -> {
			List<Userr> users = new ArrayList<>();
			List<Car> cars = new ArrayList<>();
			Faker faker = new Faker();

			for(int i = 0; i < 20; i++) {
				users.add(userRepository.save(new Userr(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress())));
			}

			cars.add(carRepository.save(new Car("1224", BigDecimal.valueOf(132, 0), Brand.BMW, false,true)));
			cars.add(carRepository.save(new Car("1233", BigDecimal.valueOf(89, 0), Brand.TESLA, true)));
			cars.add(carRepository.save(new Car("1213", BigDecimal.valueOf(50, 0), Brand.BMW, false)));
			cars.add(carRepository.save(new Car("4544", BigDecimal.valueOf(132, 0), Brand.MERCEDES, false)));
			List<CarBooking> carBookings=new ArrayList<>();
			Userr user = userRepository.save(new Userr(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress()));
			Userr use2 = userRepository.save(new Userr(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress()));
        	Car car= carRepository.save(new Car("1225", BigDecimal.valueOf(132, 0), Brand.BMW, false,true));
       		CarBooking carBooking= new CarBooking(user,car);

       		CarBooking carBooking2= new CarBooking(use2,cars.get(cars.size() - 1));
		    carBookings.add(carBooking);
        	carBookings.add(carBooking2);
			carBookingRepository.saveAll(carBookings);


		};


	}
}
