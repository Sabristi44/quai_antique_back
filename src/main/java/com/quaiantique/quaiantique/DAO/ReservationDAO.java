package com.quaiantique.quaiantique.DAO;

import org.springframework.data.repository.CrudRepository;
import com.quaiantique.quaiantique.Entities.Reservation;

public interface ReservationDAO extends CrudRepository<Reservation, Long> {
    
}
