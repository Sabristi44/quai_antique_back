package com.quaiantique.quaiantique.Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.quaiantique.quaiantique.Controller.CompositionInfo;
import com.quaiantique.quaiantique.DAO.CompositionDAO;
import com.quaiantique.quaiantique.DAO.MenuDAO;
import com.quaiantique.quaiantique.Entities.Composition;
import com.quaiantique.quaiantique.Entities.Menu;

@Service
public class CompositionManagerImpl implements CompositionManager {
    
    @Autowired
    CompositionDAO compositionDAO;

    @Autowired
    MenuDAO menuDAO;


    @Override
    public void addComposition(CompositionInfo compositionInfo) {
        Menu menu = menuDAO.findById(compositionInfo.menuId).get();
        Composition composition = new Composition(compositionInfo.price,compositionInfo.description,menu);
        compositionDAO.save(composition);
    }
}
