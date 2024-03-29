package com.quaiantique.quaiantique.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.quaiantique.quaiantique.Service.UserManager;
import com.quaiantique.quaiantique.Entities.User;;


@RestController
public class UserController {
    
    @Autowired
    UserManager manager;

    @PostMapping("/login")
    public User login(@RequestBody UserInfo userInfo) {
        return manager.login(userInfo);
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody UserInfo userInfo) {
       return manager.createUser(userInfo);
    }

    @PostMapping("/signup/admin")
    public void signUpAdmin(@RequestBody UserInfo userInfo) {
       manager.createUserAdmin(userInfo);
    }

    @PostMapping("/allergy")
    public void allergy(@RequestBody AllergyInfo allergyInfo) {
        manager.updateUserAllergies(allergyInfo);
    }
}
