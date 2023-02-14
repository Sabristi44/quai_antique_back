package com.quaiantique.quaiantique.Service;

import com.quaiantique.quaiantique.Entities.Schedule;
import com.quaiantique.quaiantique.Controller.ScheduleInfo;

public interface ScheduleManager {
    
    void updateSchedule(ScheduleInfo scheduleInfo);
    Schedule getSchedule();
}
