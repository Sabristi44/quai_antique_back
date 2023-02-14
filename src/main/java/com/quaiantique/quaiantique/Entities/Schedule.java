package com.quaiantique.quaiantique.Entities;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Schedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime openingMonday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime closingMonday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime openingTuesday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime closingTuesday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime openingWednesday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime closingWednesday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime openingThursday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime closingThursday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime openingFriday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime closingFriday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime openingSaturday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime closingSaturday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime openingSunday;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime closingSunday;
}
