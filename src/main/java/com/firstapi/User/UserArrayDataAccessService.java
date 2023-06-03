package com.firstapi.User;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

@Repository
public class UserArrayDataAccessService implements UserDAO {
    private static final List<Userr> users ;
    static {
        users = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            Faker faker = new Faker();
            users.add(new Userr(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress()));
        }
    }

    public List<Userr> getUsers () {
            return users;
        }

    @Override
    public Optional<Userr> getUserById(UUID id) {
        return users.stream().
                filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public Boolean existUserWithEmail(String email) {
        return null;
    }

    @Override
    public void addUser(Userr user) {

    }

    @Override
    public void deleteUser(Userr user) {

    }
}
