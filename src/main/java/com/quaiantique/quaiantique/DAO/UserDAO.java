package com.quaiantique.quaiantique.DAO;

import org.springframework.data.repository.CrudRepository;
import com.quaiantique.quaiantique.Entities.User;;

public interface UserDAO extends CrudRepository<User, Long> {
    
}
