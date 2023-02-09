package com.quaiantique.quaiantique.DAO;

import org.springframework.data.repository.CrudRepository;
import com.quaiantique.quaiantique.Entities.Dish;

public interface DishDAO extends CrudRepository<Dish, Long>{

}
