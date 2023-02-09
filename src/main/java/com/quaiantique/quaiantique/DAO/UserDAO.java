package com.quaiantique.quaiantique.DAO;

import org.springframework.data.repository.CrudRepository;
import com.quaiantique.quaiantique.Entities.User;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

public interface UserDAO extends CrudRepository<User, Long> {
    
    @Query("SELECT u FROM User u WHERE u.mail = :mail AND u.password = :password")
    User login(@Param("mail") String mail,@Param("password") String password);
}
