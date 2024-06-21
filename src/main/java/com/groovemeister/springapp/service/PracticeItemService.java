package com.groovemeister.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groovemeister.springapp.model.PracticeItem;
import com.groovemeister.springapp.repository.PracticeItemRepository;

@Service
public class PracticeItemService {
   
    @Autowired
    private PracticeItemRepository practiceItemRepository;

    public List<PracticeItem> findAll() {
        return practiceItemRepository.findAll();
    }

    public Optional<PracticeItem> findById(Long id) {
        return practiceItemRepository.findById(id);
    }

    public PracticeItem save(PracticeItem practiceItem) {
        return practiceItemRepository.save(practiceItem);
    }

    public void deleteById(Long id) {
        practiceItemRepository.deleteById(id);
    }

    public List<PracticeItem> findByTopic(String topic) {
        return practiceItemRepository.findByTopic(topic);
    }
 
}
