package com.quaiantique.quaiantique.DAO;

import org.springframework.data.repository.CrudRepository;
import com.quaiantique.quaiantique.Entities.Allergy;

public interface AllergyDAO extends CrudRepository<Allergy, Long> {
    
}
