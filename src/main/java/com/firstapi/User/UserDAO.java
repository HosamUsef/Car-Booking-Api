package com.firstapi.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDAO {
    List<Userr> getUsers();
    Optional<Userr> getUserById(UUID id);
    Boolean existUserWithEmail(String email);
    void addUser(Userr user);

    void deleteUser(Userr user);
}
