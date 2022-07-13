package com.kapture.projectAPI.model;


import lombok.Data;

@Data
public class RegisterModel {

    private long userId;
    private String firstName;
    private String lastName;

    private String email;
    private String password;


}
