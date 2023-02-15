package com.quaiantique.quaiantique.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String image;
    private String title;
    private String description;
    private Double price;
    private String category;

    public Dish(String title, String description, Double price, String category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
      }
    
}
