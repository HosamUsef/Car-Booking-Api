package com.firstapi.User;

import com.firstapi.Car.CarRegistrationRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }
    @GetMapping
    public List<Userr> getUsers(){
        return userServices.getAllUsers();
    }
    @GetMapping("{userId}")
    public Userr getUserById(
            @PathVariable("userId")UUID userId){
        return userServices.getSingleUser(userId);
    }
    @PostMapping
    public void addUser(
            @RequestBody UserRegisrationRequest request
    ){
        userServices.addUser(request);
    }
    @DeleteMapping("{userId}")
    public void deleteUserByUuid(@PathVariable("userId") UUID userId){
        userServices.deleteUserByUuid(userId);
    }
}
