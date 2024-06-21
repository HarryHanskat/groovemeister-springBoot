package com.groovemeister.springapp.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.groovemeister.springapp.model.PracticeItem;

public interface PracticeItemRepository extends JpaRepository<PracticeItem, Long> {
   
    List<PracticeItem> findByDescription(String description);

    // Custom query example
    @Query("SELECT item from PracticeItem WHERE item.topic = 'CAGED'")
    List<PracticeItem> findByTopic(@Param("topic") String topic);
    
}
