package com.quaiantique.quaiantique.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quaiantique.quaiantique.Entities.User;
import com.quaiantique.quaiantique.DAO.UserDAO;
import com.quaiantique.quaiantique.Controller.UserInfo;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(UserInfo userInfo) {
        return userDAO.login(userInfo.mail,userInfo.password);
    }

    @Override
    public void createUser(UserInfo userInfo) {
        final User user = new User(userInfo.mail,userInfo.password);
        userDAO.save(user);
    }
}
