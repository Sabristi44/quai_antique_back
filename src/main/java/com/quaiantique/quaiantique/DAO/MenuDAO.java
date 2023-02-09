package com.quaiantique.quaiantique.DAO;

import org.springframework.data.repository.CrudRepository;
import com.quaiantique.quaiantique.Entities.Menu;

public interface MenuDAO  extends CrudRepository<Menu, Long>{
    
}
