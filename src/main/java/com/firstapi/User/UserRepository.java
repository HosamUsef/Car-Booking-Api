package com.firstapi.User;

import com.firstapi.Car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository
        <Userr, UUID> {
    Optional<Userr> findByUuid(UUID uuid);
    Boolean existsByEmail(String email);

}
