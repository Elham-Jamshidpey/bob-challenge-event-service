package com.takeaway.eventservice.kafka;

import com.takeaway.eventservice.model.EventType;
import com.takeaway.eventservice.model.Event;
import com.takeaway.eventservice.service.EventBizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class EmployeeEventConsumer {

    @Autowired
    EventBizService eventBizService;

    private static final Logger log = LoggerFactory.getLogger(EmployeeEventConsumer.class);

    @KafkaListener(topics = "CREATE", groupId = "employee_consumer")
    public void consumeCreateEmployee(String message) {
        try {
            log.debug(String.format("Consumed message -> %s", message));
            eventBizService.create(initializeEvent(message, EventType.CREATE));
        } catch (Exception e) {
            log.debug("*** Consuming failed for CREATE ***"+ e.getMessage());
        }
    }

    @KafkaListener(topics = "UPDATE", groupId = "employee_consumer")
    public void consumeUpdateEmployee(String message) {
        try {
            log.debug(String.format("Consumed message -> %s", message));
            eventBizService.create(initializeEvent(message, EventType.UPDATE));
        } catch (Exception e) {
            log.debug("*** Consuming failed for UPDATE***"+ e.getMessage());
        }
    }

    @KafkaListener(topics = "DELETE", groupId = "employee_consumer")
    public void consumeDeleteEmployee(String message) {
        try {
            log.debug(String.format("Consumed message -> %s", message));
            eventBizService.create(initializeEvent(message, EventType.DELETE));
        } catch (Exception e) {
            log.debug("*** Consuming failed for DELETE ***"+ e.getMessage());
        }
    }

    private Event initializeEvent(String employeeUuid, EventType eventType) {
        Event event = new Event();
        event.setEventType(eventType);
        event.setEmployeeUuid(UUID.fromString(employeeUuid));
        event.setCreationDate(LocalDate.now());
        return event;
    }
}
