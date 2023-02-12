package com.restapitrialtask.restapitrialtask.repository;

import com.restapitrialtask.restapitrialtask.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<UserModel, Long> {
    @Query("SELECT user FROM UserModel user WHERE user.userEmail = :newUserEmail")
    List<UserModel> findByEmail(String newUserEmail);

}
