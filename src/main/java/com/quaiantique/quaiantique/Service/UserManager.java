package com.quaiantique.quaiantique.Service;

import com.quaiantique.quaiantique.Entities.User;
import com.quaiantique.quaiantique.Controller.UserInfo;
import com.quaiantique.quaiantique.Controller.AllergyInfo;

public interface UserManager {
    
    User login(UserInfo userInfo);
    User createUser(UserInfo userInfo);
    void createUserAdmin(UserInfo userInfo);
    void updateUserAllergies(AllergyInfo allergyInfos);
}
