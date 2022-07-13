package com.kapture.projectAPI.controller;

import com.kapture.projectAPI.entities.Data;
import com.kapture.projectAPI.entities.User;
import com.kapture.projectAPI.model.DataModel;
import com.kapture.projectAPI.model.RegisterModel;
import com.kapture.projectAPI.model.UserModel;
import com.kapture.projectAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private UserService userService;



    @GetMapping("/getAll")
    public List<User> GetALL()
    {
        return userService.show();
    }

/*
    @GetMapping("/get/{userId}")
    public User Get(@PathVariable long userId)
    {
        return userService.findByUserId(userId);
    }


    @PutMapping("/update")
    public String Update(@RequestBody User user)
    {
        userService.update(user);
        return "updated";
    }



    @PostMapping("/register")
    public String Register(@RequestBody User user)
    {
        userService.create(user);
        return "user successfully register";
    }*/


    @GetMapping("/getdata")
    public List<Data> GetData(@RequestBody DataModel dataModel)
    {
        return userService.GetData(dataModel);
        // return "data added successfully";
    }




    // Add the data field to the user ...  get password & username then ---> permit to store data
    @PostMapping("/add")
    public String Update(@RequestBody DataModel dataModel)
    {
        return userService.addUserData(dataModel);
       // return "data added successfully";
    }

    // works with public end point access without password
    @PostMapping("/registermodel")
    public String Registermodel(@RequestBody RegisterModel registerModel)
    {
        userService.adduser(registerModel);
        return "user successfully register";
    }

    @GetMapping("/home")
    public String Home()
    {
        return "Welcome to Things Speak API";
    }

    // works
    @DeleteMapping("/delete")
    public String Delete(@RequestBody UserModel userModel)
    {
        if(userModel==null) return "null";
        if(userService.Delete(userModel))
        {
            return "Deleted";
        }
        return "something went wrong "+userModel.getEmail()+ " "+userModel.getPassword();

    }

}

