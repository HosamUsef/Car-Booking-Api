package com.firstapi.User;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("JPA")
public class UserJPADataAccesingService implements UserDAO {
    private final UserRepository userRepository;

    public UserJPADataAccesingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Userr> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Userr> getUserById(UUID id) {
        return userRepository.findByUuid(id);
    }

    @Override
    public Boolean existUserWithEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void addUser(Userr user){
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Userr user) {
        userRepository.delete(user);
    }
}
