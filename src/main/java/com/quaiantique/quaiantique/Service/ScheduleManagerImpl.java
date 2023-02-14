package com.quaiantique.quaiantique.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

import com.quaiantique.quaiantique.Entities.Schedule;
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
}
