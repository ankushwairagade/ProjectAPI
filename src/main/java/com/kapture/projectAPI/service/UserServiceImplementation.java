package com.kapture.projectAPI.service;

import com.kapture.projectAPI.entities.Data;
import com.kapture.projectAPI.entities.Role;
import com.kapture.projectAPI.entities.User;
import com.kapture.projectAPI.model.DataModel;
import com.kapture.projectAPI.model.RegisterModel;
import com.kapture.projectAPI.model.UserModel;
import com.kapture.projectAPI.repository.DataRepository;
import com.kapture.projectAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImplementation implements UserService{


    @Autowired
    UserRepository userRepository;

    @Autowired
    DataRepository dataRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByUserId(long userId) {
        return userRepository.findByuserId(userId);
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long userId) {
        User user = userRepository.findByuserId(userId);
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> show() {
        return userRepository.findAll();
    }






    //works  --> Delete the user Data
    @Override
    public boolean Delete(UserModel userModel) {

    //    User user = userRepository.findByEmail(userModel.getEmail());

        User user = userRepository.findByuserId(userModel.getId());
        if(user == null) return false;
        if(Objects.equals(user.getEmail(), userModel.getEmail()))
        {
            userRepository.delete(user);
            return true;
        }

        return false;
    }


    // works  --> Register User
    @Override
    public void adduser(RegisterModel registerModel) {

    User user = new User();
    user.setFirstName(registerModel.getFirstName());
    user.setLastName(registerModel.getLastName());
    user.setEmail(registerModel.getEmail());

    registerModel.setPassword(bCryptPasswordEncoder.encode(registerModel.getPassword()));

    user.setPassword(registerModel.getPassword());

    userRepository.save(user);
    }

    //works --> Data user Data
    @Override
    public String addUserData(DataModel dataModel) {

        User user = userRepository.findByEmail(dataModel.getEmail());

            Data d = new Data();
            d.setUser(user);
            d.setField1(dataModel.getField1());
            d.setField2(dataModel.getField2());

            dataRepository.save(d);
                return "added";

    }

    @Override
    public List<Data> GetData(DataModel dataModel) {
        User user = userRepository.findByEmail(dataModel.getEmail());
        return user.getList();
    }


}
