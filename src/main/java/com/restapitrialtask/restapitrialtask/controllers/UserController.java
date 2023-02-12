package com.restapitrialtask.restapitrialtask.controllers;

import com.restapitrialtask.restapitrialtask.dto.UserDTO;
import com.restapitrialtask.restapitrialtask.models.UserModel;
import com.restapitrialtask.restapitrialtask.repository.UsersRepo;
import com.restapitrialtask.restapitrialtask.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class UserController {

    private UsersRepo usersRepo;
    private UserService userService;

    @GetMapping("api/users")
    public List<UserModel> mainShow(){
        return usersRepo.findAll();
    }

    //Creation of a new user
    @PostMapping("api/create")
    public String createAccount(@RequestBody UserDTO newUser){
        if(userService.createUser(newUser).getUserEmail() == null)
            return "That email already in use!";
        else
            return "You have created an account!";
    }
}
