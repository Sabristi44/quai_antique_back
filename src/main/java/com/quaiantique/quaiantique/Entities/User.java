package com.quaiantique.quaiantique.Entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Id;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String mail;
    private String password;
    private String allergies;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
    private boolean isAdmin;
    private int numPerson;

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;
        this.isAdmin = false;
        this.numPerson = 1;
      }

}
