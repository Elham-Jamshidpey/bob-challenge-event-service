package com.takeaway.eventservice.service;

import com.takeaway.eventservice.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventBizService {

    @Autowired
    EventDataService eventDataService;

    public Event create(Event event){
        return eventDataService.create(event);
    }

    public List<Event> findAllByEmployeeUuid(UUID employeeUuid) {
        Optional<List<Event>> optionalEvent = eventDataService.findAllByEmployeeUuid(employeeUuid);
        if(optionalEvent.isPresent()){
            Collections.sort(optionalEvent.get());
            return optionalEvent.get();
        }
        return null;
    }
}
