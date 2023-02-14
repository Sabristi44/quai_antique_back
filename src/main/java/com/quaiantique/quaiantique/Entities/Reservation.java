package com.quaiantique.quaiantique.Entities;

import java.time.LocalDateTime;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numPerson;
    private LocalDateTime reservationDate;
    private String allergies;
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

    public Reservation(int numPerson, LocalDateTime reservationDate, String allergies, User user) {
        this.numPerson = numPerson;
        this.reservationDate = reservationDate;
        this.allergies = allergies;
        this.user = user;
      }
    }
