package com.quaiantique.quaiantique.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User login(UserInfo userInfo) {
        User user = userDAO.login(userInfo.mail);
        String encodePassword = this.passwordEncoder.encode(user.getPassword());
        boolean isPasswordEqual =  passwordEncoder.matches(userInfo.password, encodePassword);
        if(isPasswordEqual) {
            return user;
        } else {
            return user;
        }
    }

    @Override
    public void createUser(UserInfo userInfo) {
        User user = userDAO.login(userInfo.mail); 
        if(user == null) {
        String encodePassword = this.passwordEncoder.encode(userInfo.password);
        User userCreate = new User(userInfo.mail,encodePassword);
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
