package com.takeaway.eventservice.service;

import com.takeaway.eventservice.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventDataService {

    @Autowired
    EventRepository repository;

    public Event create(Event event){
        return repository.save(event);
    }

    public Optional<List<Event>> findAllByEmployeeUuid(UUID employeeUuid){
        return repository.findAllByEmployeeUuid(employeeUuid);
    }

}
