package com.quaiantique.quaiantique.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;

import com.quaiantique.quaiantique.Entities.Schedule;
import com.quaiantique.quaiantique.Entities.Slot;
import com.quaiantique.quaiantique.DAO.ScheduleDAO;
import com.quaiantique.quaiantique.Controller.ScheduleInfo;

@Service
public class ScheduleManagerImpl implements ScheduleManager {
    
    @Autowired
    private ScheduleDAO scheduleDAO;

    @Override
    public void updateSchedule(ScheduleInfo scheduleInfo) {
        final Schedule schedule = new Schedule(
        1L,
        LocalTime.parse(scheduleInfo.openingMonday),
        LocalTime.parse(scheduleInfo.closingMonday),
        LocalTime.parse(scheduleInfo.openingTuesday), 
        LocalTime.parse(scheduleInfo.closingTuesday),
        LocalTime.parse(scheduleInfo.openingWednesday),
        LocalTime.parse(scheduleInfo.closingWednesday),
        LocalTime.parse(scheduleInfo.openingThursday),
        LocalTime.parse(scheduleInfo.closingThursday),
        LocalTime.parse(scheduleInfo.openingFriday),
        LocalTime.parse(scheduleInfo.closingFriday),
        LocalTime.parse(scheduleInfo.openingSaturday),
        LocalTime.parse(scheduleInfo.closingSaturday),
        LocalTime.parse(scheduleInfo.openingSunday),
        LocalTime.parse(scheduleInfo.closingSunday)
        );
        scheduleDAO.save(schedule);
    }

    @Override
    public Schedule getSchedule() {
        return scheduleDAO.findById(1L).get();
    }

    @Override
    public List<Slot> getSlot() {
    Schedule schedule = scheduleDAO.findById(1L).get();
    LocalDate today = LocalDate.now();
    List<Slot> slots = new ArrayList<Slot>();
    LocalDate currentDay = today;
    for(int i = 0; i<= 7; i++) {
    if(i != 0) {
    currentDay = currentDay.plusDays(1);
    }
    DayOfWeek dayOfWeek = currentDay.getDayOfWeek();
    List<LocalTime> timeSlot = new ArrayList<LocalTime>();
    switch(dayOfWeek){
        case MONDAY: 
           timeSlot = getLocalTimeSlot(schedule.getOpeningMonday(),schedule.getClosingMonday(),today.equals(currentDay));
            break;
        case TUESDAY: 
            timeSlot = getLocalTimeSlot(schedule.getOpeningTuesday(),schedule.getClosingTuesday(),today.equals(currentDay));
            break;
        case WEDNESDAY: 
            timeSlot = getLocalTimeSlot(schedule.getOpeningWednesday(),schedule.getClosingWednesday(),today.equals(currentDay));
            break;
        case THURSDAY: 
            timeSlot = getLocalTimeSlot(schedule.getOpeningThursday(),schedule.getClosingThursday(),today.equals(currentDay));
            break;
        case FRIDAY: 
            timeSlot = getLocalTimeSlot(schedule.getOpeningFriday(),schedule.getClosingFriday(),today.equals(currentDay));
            break;
        case SATURDAY: 
            timeSlot = getLocalTimeSlot(schedule.getOpeningSaturday(),schedule.getClosingSaturday(),today.equals(currentDay));
            break;
        case SUNDAY: 
            timeSlot = getLocalTimeSlot(schedule.getOpeningSunday(),schedule.getClosingSunday(),today.equals(currentDay));
            break;
        default:
            break;
    }
    Slot slot = new Slot(currentDay,dayOfWeek,timeSlot);
    slots.add(slot);
    }
    return slots;

    }


    public List<LocalTime> getLocalTimeSlot(LocalTime opening, LocalTime closing,boolean isToday) {
      LocalTime closingMenuHour = closing.minusHours(1);
      List<LocalTime> slots = new ArrayList<LocalTime>();
      if(opening.isAfter(LocalTime.now()) || !isToday) {
        slots.add(opening);
      }
      LocalTime currentLocal = opening;
      while(currentLocal.isBefore(closingMenuHour)) {
        currentLocal = currentLocal.plusMinutes(15);
        if(currentLocal.isAfter(LocalTime.now()) || !isToday){
        slots.add(currentLocal);
        }
      }  
      return slots;
    }
}
