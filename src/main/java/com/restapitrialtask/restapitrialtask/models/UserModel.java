package com.restapitrialtask.restapitrialtask.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String userName;

    @Column
    private String userEmail;

    @Column
    private String userPassword;

    @Column
    private Timestamp creationDate;

    public UserModel(String userName, String userEmail, String userPassword, Timestamp timestamp) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.creationDate = timestamp;
    }
}
