package com.quaiantique.quaiantique.Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class Slot {
    
    private LocalDate day;
    private List<LocalTime> slots = new ArrayList<LocalTime>();

}
