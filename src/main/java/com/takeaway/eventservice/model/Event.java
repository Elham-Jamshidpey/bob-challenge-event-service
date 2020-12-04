package com.takeaway.eventservice.model;

import com.takeaway.eventservice.EventType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Event implements Comparable<Event>{

    @Id
    @GeneratedValue(generator="system-uuid")
    private UUID uuid;

    @NotNull
    UUID employeeUuid;

    @NotNull
    EventType eventType;

    @NotNull
    LocalDate creationDate;

    public UUID getEmployeeUuid() {
        return employeeUuid;
    }

    public void setEmployeeUuid(UUID employeeUuid) {
        this.employeeUuid = employeeUuid;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int compareTo(Event event) {
        return getCreationDate().compareTo(event.getCreationDate());
    }
}
