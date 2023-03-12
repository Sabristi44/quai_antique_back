package com.quaiantique.quaiantique.Entities;

import java.time.LocalDateTime;
import jakarta.persistence.Id;
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
    private String mail;

    public Reservation(int numPerson, LocalDateTime reservationDate, String allergies, String mail) {
        this.numPerson = numPerson;
        this.reservationDate = reservationDate;
        this.allergies = allergies;
        this.mail = mail;
      }
    }
