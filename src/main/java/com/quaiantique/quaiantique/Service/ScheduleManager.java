package com.quaiantique.quaiantique.Service;

import com.quaiantique.quaiantique.Entities.Schedule;
import com.quaiantique.quaiantique.Entities.Slot;
import com.quaiantique.quaiantique.Controller.ScheduleInfo;
import java.util.List;

public interface ScheduleManager {
    
    void updateSchedule(ScheduleInfo scheduleInfo);
    Schedule getSchedule();
    List<Slot> getSlot();
}
