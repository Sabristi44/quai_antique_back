package com.quaiantique.quaiantique.Entities;

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
    private String openingMonday;
    @JsonFormat(pattern = "HH:mm")
    private String closingMonday;
    @JsonFormat(pattern = "HH:mm")
    private String openingTuesday;
    @JsonFormat(pattern = "HH:mm")
    private String closingTuesday;
    @JsonFormat(pattern = "HH:mm")
    private String openingWednesday;
    @JsonFormat(pattern = "HH:mm")
    private String closingWednesday;
    @JsonFormat(pattern = "HH:mm")
    private String openingThursday;
    @JsonFormat(pattern = "HH:mm")
    private String closingThursday;
    @JsonFormat(pattern = "HH:mm")
    private String openingFriday;
    @JsonFormat(pattern = "HH:mm")
    private String closingFriday;
    @JsonFormat(pattern = "HH:mm")
    private String openingSaturday;
    @JsonFormat(pattern = "HH:mm")
    private String closingSaturday;
    @JsonFormat(pattern = "HH:mm")
    private String openingSunday;
    @JsonFormat(pattern = "HH:mm")
    private String closingSunday;
}
