package com.quaiantique.quaiantique.Entities;



import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @OneToMany(cascade = CascadeType.ALL)
    private List<Allergy> allergies = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;
    private int maxNumPerson;
}
