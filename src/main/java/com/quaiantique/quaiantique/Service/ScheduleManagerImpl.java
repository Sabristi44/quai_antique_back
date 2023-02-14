package com.quaiantique.quaiantique.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        scheduleInfo.openingMonday,
        scheduleInfo.closingMonday,
        scheduleInfo.openingTuesday, 
        scheduleInfo.closingTuesday,
        scheduleInfo.openingWednesday,
        scheduleInfo.closingWednesday,
        scheduleInfo.openingThursday,
        scheduleInfo.closingThursday,
        scheduleInfo.openingFriday,
        scheduleInfo.closingFriday,
        scheduleInfo.openingSaturday,
        scheduleInfo.closingSaturday,
        scheduleInfo.openingSunday,
         scheduleInfo.closingSunday
        );
        scheduleDAO.save(schedule);
    }

    @Override
    public Schedule getSchedule() {
        return scheduleDAO.findById(1L).get();
    }
}
