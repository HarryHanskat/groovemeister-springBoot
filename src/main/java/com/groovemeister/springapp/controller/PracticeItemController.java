package com.groovemeister.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.groovemeister.springapp.model.PracticeItem;
import com.groovemeister.springapp.service.PracticeItemService;

@RestController
@RequestMapping("/practiceItems")
public class PracticeItemController {
    
    @Autowired
    private PracticeItemService practiceItemService;

    @GetMapping
    public List<PracticeItem> findAll() {
        return practiceItemService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PracticeItem> findById(@PathVariable Long id) {
        return practiceItemService.findById(id);
    }

    //Create practice item
    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping
    public PracticeItem create(@RequestBody PracticeItem practiceItem) {
        return practiceItemService.save(practiceItem);
    }

    //update a practice item
    //must provide id in response body so JPA knows which item to update in the db
    @PutMapping
    public PracticeItem update(@RequestBody PracticeItem practiceItem) {
        return practiceItemService.save(practiceItem);
    }
    
    //delete a practice item
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        practiceItemService.deleteById(id);
    }

    //find by topic
    @GetMapping("/find/topic/{topic}")
    public List<PracticeItem> findByTopic(@PathVariable String topic) {
        return practiceItemService.findByTopic(topic);
    }
    
}
