package com.takeaway.eventservice.service;

import com.takeaway.eventservice.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

    Optional<List<Event>> findAllByEmployeeUuid(UUID uuid);
}
