package com.quaiantique.quaiantique.Service;

import com.quaiantique.quaiantique.Controller.ReservationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quaiantique.quaiantique.Entities.Reservation;
import com.quaiantique.quaiantique.DAO.ReservationDAO;

import java.time.LocalDateTime;

@Service
public class ReservationManagerImpl implements ReservationManager {

    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    public void addReservation(ReservationInfo reservationInfo) {
        final Reservation reservation = new Reservation(reservationInfo.numPerson,
        LocalDateTime.of(reservationInfo.date, reservationInfo.hour),
        reservationInfo.allergies,
        reservationInfo.mail);
        reservationDAO.save(reservation);
    }

}
