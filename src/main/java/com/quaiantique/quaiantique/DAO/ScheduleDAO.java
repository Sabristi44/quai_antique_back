package com.quaiantique.quaiantique.DAO;

import org.springframework.data.repository.CrudRepository;
import com.quaiantique.quaiantique.Entities.Schedule;

public interface ScheduleDAO extends CrudRepository<Schedule, Long>{
    
}
