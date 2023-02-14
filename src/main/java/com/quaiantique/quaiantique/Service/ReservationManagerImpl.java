package com.quaiantique.quaiantique.Service;

import com.quaiantique.quaiantique.Controller.ReservationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quaiantique.quaiantique.Entities.Reservation;
import com.quaiantique.quaiantique.Entities.User;
import com.quaiantique.quaiantique.DAO.ReservationDAO;
import com.quaiantique.quaiantique.DAO.UserDAO;

import java.time.LocalDateTime;

@Service
public class ReservationManagerImpl implements ReservationManager {

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addReservation(ReservationInfo reservationInfo) {
        User user = userDAO.findById(reservationInfo.idUser).get();
        final Reservation reservation = new Reservation(reservationInfo.numPerson,
        LocalDateTime.parse(reservationInfo.reservationDate),
        reservationInfo.allergies,
        user);
        reservationDAO.save(reservation);
    }

}
