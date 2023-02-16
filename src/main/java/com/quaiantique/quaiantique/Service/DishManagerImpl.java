package com.quaiantique.quaiantique.Service;

import com.quaiantique.quaiantique.DAO.DishDAO;
import com.quaiantique.quaiantique.Entities.Dish;
import com.quaiantique.quaiantique.Controller.DishInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishManagerImpl implements DishManager {
    
    @Autowired
    private DishDAO dishDAO;

    @Override
    public void addDish(DishInfo dishInfo) {
        Dish dish = new Dish(dishInfo.title,dishInfo.description, dishInfo.price, dishInfo.category);
        dishDAO.save(dish);
    }

    @Override
    public List<Dish> findAllDishes() {
        List<Dish> dishes = new ArrayList<Dish>();
        dishes = dishDAO.findAll();
        return dishes;
    }
}
