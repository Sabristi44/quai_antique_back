package com.quaiantique.quaiantique.Service;

import com.quaiantique.quaiantique.Entities.User;
import com.quaiantique.quaiantique.Controller.UserInfo;
import com.quaiantique.quaiantique.Controller.AllergyInfo;

public interface UserManager {
    
    User login(UserInfo userInfo);
    void createUser(UserInfo userInfo);
    void updateUserAllergies(AllergyInfo allergyInfos);
}
