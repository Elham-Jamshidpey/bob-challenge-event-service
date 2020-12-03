package com.takeaway.eventservice.model;

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
    String action;

    LocalDate creationDate;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getEmployeeUuid() {
        return employeeUuid;
    }

    public void setEmployeeUuid(UUID employeeUuid) {
        this.employeeUuid = employeeUuid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
