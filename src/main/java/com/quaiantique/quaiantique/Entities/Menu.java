package com.quaiantique.quaiantique.Entities;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.ArrayList;

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
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Composition> compositions = new ArrayList<>();

}
