package com.quaiantique.quaiantique.Service;

import com.quaiantique.quaiantique.DAO.MenuDAO;
import com.quaiantique.quaiantique.Entities.Menu;
import com.quaiantique.quaiantique.Controller.MenuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuManagerImpl implements MenuManager {
    
    @Autowired
    private MenuDAO menuDAO;

    @Override
    public void addMenu(MenuInfo menuInfo) {
        Menu menu= new Menu(menuInfo.title);
        menuDAO.save(menu);
    }

    @Override
    public List<Menu> findAllMenues() {
        List<Menu> menues = new ArrayList<Menu>();
        menues = menuDAO.findAll();
        return menues;
    }

}
