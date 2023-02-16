package com.quaiantique.quaiantique.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.quaiantique.quaiantique.Service.CompositionManager;

@RestController
public class CompositionController {

    @Autowired
    CompositionManager manager;

    @PostMapping("/composition")
    public void addComposition(@RequestBody CompositionInfo compositionInfo) {
        manager.addComposition(compositionInfo);
    }
}
