package com.firstapi.User;

import com.firstapi.Exceptions.DublicateResourceException;
import com.firstapi.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServices {

    private final UserDAO userDAO;

    public UserServices(@Qualifier("JPA") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<Userr> getAllUsers() {
        return userDAO.getUsers();
    }


    public Userr getSingleUser(UUID id) {
        return userDAO.getUserById(id).orElseThrow(()-> new
                ResourceNotFoundException("User with  id [%s] not found".
                formatted(id)));
    }
    public void addUser(UserRegisrationRequest request){
        if(userDAO.existUserWithEmail(request.email())){
            throw new DublicateResourceException(
                    "email already taken"
            );
        }
        Userr user = new Userr(
                request.firstname(),
                request.lastname(),
                request.email()
        );
        userDAO.addUser(user);
    }

    public void deleteUserByUuid(UUID userId) {
        Userr user=userDAO.getUserById( userId).orElseThrow(() ->
                new ResourceNotFoundException("User with id [%s] not found".formatted(userId))
        );
        userDAO.deleteUser(user);

    }
}
