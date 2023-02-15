package com.quaiantique.quaiantique.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import com.quaiantique.quaiantique.Service.DishManager;
import java.util.List;
import com.quaiantique.quaiantique.Entities.Dish;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class DishController {

    @Autowired
    DishManager manager;

    @PostMapping("/dish")
    public void addDish(@RequestBody DishInfo dishInfo) {
        manager.addDish(dishInfo);
    }

    @GetMapping("/dish")
    public List<Dish> findAllDishes() {
        return manager.findAllDishes();
    }

}
