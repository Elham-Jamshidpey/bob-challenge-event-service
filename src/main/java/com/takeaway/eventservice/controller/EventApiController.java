package com.takeaway.eventservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.takeaway.eventservice.model.Event;
import com.takeaway.eventservice.service.EventBizService;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Events;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-04T10:09:05.546Z")

@Controller
public class EventApiController implements EventApi {

    @Autowired
    EventBizService eventBizService;

    private static final Logger log = LoggerFactory.getLogger(EventApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public EventApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Events> getEventsByEmployeeUuid(@ApiParam(value = "UUID of employee to return events",required=true) @PathVariable("employeeUuid") String employeeUuid) {
        try {
            List<Event> events = eventBizService.findAllByEmployeeUuid(UUID.fromString(employeeUuid));
            String content = objectMapper.writeValueAsString(events);
            return new ResponseEntity<Events>(objectMapper.readValue(content, Events.class), HttpStatus.OK);
        } catch (IOException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Events>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
