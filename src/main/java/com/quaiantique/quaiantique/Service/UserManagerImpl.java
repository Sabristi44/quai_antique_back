package com.quaiantique.quaiantique.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.quaiantique.quaiantique.Entities.User;
import com.quaiantique.quaiantique.DAO.UserDAO;
import com.quaiantique.quaiantique.Controller.UserInfo;
import com.quaiantique.quaiantique.Controller.AllergyInfo;

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDAO userDAO;

    BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

    @Override
    public User login(UserInfo userInfo) {
        User user = userDAO.login(userInfo.mail);
        boolean isPasswordMatched = bcryptEncoder.matches(userInfo.password, user.getPassword());
        if(isPasswordMatched) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User createUser(UserInfo userInfo) {
        User user = userDAO.login(userInfo.mail); 
        if(user == null) {
        String encodePassword = bcryptEncoder.encode(userInfo.password);
        User userCreate = new User(userInfo.mail,encodePassword);
        userDAO.save(userCreate);
        }
        return userDAO.findByMail(userInfo.mail);
    }

    @Override
    public void createUserAdmin(UserInfo userInfo) {
        User user = userDAO.login(userInfo.mail); 
        if(user == null) {
        String encodePassword = bcryptEncoder.encode(userInfo.password);
        User userCreate = new User(userInfo.mail,encodePassword,true);
        userDAO.save(userCreate);
        }
    }

    @Override
    public void updateUserAllergies(AllergyInfo allergyInfo) {
        User user = new User();
       user = userDAO.findById(allergyInfo.id).get();
       user.setAllergies(allergyInfo.allergies);
        userDAO.save(user);
    }
}
