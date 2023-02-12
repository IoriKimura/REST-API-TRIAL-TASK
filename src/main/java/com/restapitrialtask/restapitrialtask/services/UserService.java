package com.restapitrialtask.restapitrialtask.services;

import com.restapitrialtask.restapitrialtask.dto.UserDTO;
import com.restapitrialtask.restapitrialtask.models.UserModel;
import com.restapitrialtask.restapitrialtask.repository.UsersRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@AllArgsConstructor
@Service
public class UserService {

    private UsersRepo usersRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserModel createUser(UserDTO userDTO){
        //Here we get current date and time of creation an account
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        //Here we check if we have that email in use
        if(!usersRepo.findByEmail(userDTO.getUserEmail()).isEmpty())
            return new UserModel();

        //We need to encode our new password
        userDTO.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
        UserModel userModel = new UserModel(userDTO.getUserName(),userDTO.getUserEmail(),
                userDTO.getUserPassword(), timestamp);
        return usersRepo.save(userModel);
    }
}
