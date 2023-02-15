package com.quaiantique.quaiantique.DAO;

import org.springframework.data.repository.CrudRepository;
import com.quaiantique.quaiantique.Entities.Dish;
import java.util.List;

public interface DishDAO extends CrudRepository<Dish, Long>{

    @Override
    List<Dish> findAll();
}
