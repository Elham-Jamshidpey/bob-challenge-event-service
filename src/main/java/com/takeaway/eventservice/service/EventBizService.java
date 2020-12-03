package com.takeaway.eventservice.service;

import com.takeaway.eventservice.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Event> findAllByEmployeeUuid(UUID employeeUuid){
        List<Event> events = new ArrayList<Event>();
        Optional<List<Event>> optionalEvent = eventDataService.findAllByEmployeeUuid(employeeUuid);
        if(optionalEvent.isPresent()){
            events.addAll(optionalEvent.get());
            Collections.sort(events);
        }
        return events;
    }
}
