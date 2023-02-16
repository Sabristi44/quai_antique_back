package com.quaiantique.quaiantique.DAO;

import org.springframework.data.repository.CrudRepository;
import com.quaiantique.quaiantique.Entities.Menu;
import java.util.List;

public interface MenuDAO  extends CrudRepository<Menu, Long>{
    
    @Override
    List<Menu> findAll();
}
