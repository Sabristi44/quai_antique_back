package com.quaiantique.quaiantique.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.quaiantique.quaiantique.Service.ScheduleManager;
import com.quaiantique.quaiantique.Entities.Schedule;
import com.quaiantique.quaiantique.Entities.Slot;
import java.util.List;


@RestController
public class ScheduleController {

    @Autowired
    ScheduleManager manager;

    @PostMapping("/schedule")
    public void updateSchedule(@RequestBody ScheduleInfo scheduleInfo) {
        manager.updateSchedule(scheduleInfo);
    }

    @GetMapping("/schedule")
    public Schedule getSchedule() {
        return manager.getSchedule();
    }

    @GetMapping("/slot")
    public List<Slot> getSlot() {
        return manager.getSlot();
    }
}
