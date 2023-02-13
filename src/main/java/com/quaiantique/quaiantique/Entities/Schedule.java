package com.quaiantique.quaiantique.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import java.time.LocalTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalTime openingMonday;
    private LocalTime closingMonday;
    private LocalTime openingTuesday;
    private LocalTime closingTuesday;
    private LocalTime openingWednesday;
    private LocalTime closingWednesday;
    private LocalTime openingThursday;
    private LocalTime closingThursday;
    private LocalTime openingFriday;
    private LocalTime closingFriday;
    private LocalTime openingSaturday;
    private LocalTime closingSaturday;
    private LocalTime openingSunday;
    private LocalTime closingSunday;
}
