package com.quaiantique.quaiantique.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.quaiantique.quaiantique.Service.MenuManager;
import java.util.List;
import com.quaiantique.quaiantique.Entities.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MenuController {
    
    @Autowired
    MenuManager manager;

    @PostMapping("/menu")
    public void addMenu(@RequestBody MenuInfo menuInfo) {
        manager.addMenu(menuInfo);
    }

    @GetMapping("/menu")
    public List<Menu> findMenues() {
        return manager.findAllMenues();
    }
}
