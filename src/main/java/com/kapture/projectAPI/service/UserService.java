package com.kapture.projectAPI.service;

import com.kapture.projectAPI.entities.Data;
import com.kapture.projectAPI.entities.User;
import com.kapture.projectAPI.model.DataModel;
import com.kapture.projectAPI.model.RegisterModel;
import com.kapture.projectAPI.model.UserModel;

import java.util.List;

public interface UserService {




    User findByUserId(long userId);

    void create(User user);

    void delete(long userId);

    void update(User user);

    List<User> show();

    boolean Delete(UserModel userModel);


    void adduser(RegisterModel registerModel);

    String addUserData(DataModel dataModel);

    List<Data> GetData(DataModel dataModel);
}
