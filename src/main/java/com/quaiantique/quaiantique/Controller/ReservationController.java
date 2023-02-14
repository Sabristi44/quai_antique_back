package com.quaiantique.quaiantique.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.quaiantique.quaiantique.Service.ReservationManager;

@RestController
public class ReservationController {
    
    @Autowired
    ReservationManager manager;

    @PostMapping("/reservation")
    public void addReservation(@RequestBody ReservationInfo reservationInfo) {
        manager.addReservation(reservationInfo);
    }
}
