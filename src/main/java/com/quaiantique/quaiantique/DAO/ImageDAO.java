package com.quaiantique.quaiantique.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quaiantique.quaiantique.Entities.Image;

public interface ImageDAO extends JpaRepository<Image, String> {
    
}
