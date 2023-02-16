package com.quaiantique.quaiantique.Service;

import com.quaiantique.quaiantique.Controller.MenuInfo;
import com.quaiantique.quaiantique.Entities.Menu;
import java.util.List;

public interface MenuManager {
    void addMenu(MenuInfo menuInfo);
    List<Menu> findAllMenues();
}
