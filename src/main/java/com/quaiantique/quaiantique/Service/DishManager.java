package com.quaiantique.quaiantique.Service;
import com.quaiantique.quaiantique.Controller.DishInfo;
import com.quaiantique.quaiantique.Entities.Dish;
import java.util.List;

public interface DishManager {
    void addDish(DishInfo dish);
    List<Dish> findAllDishes();
}
