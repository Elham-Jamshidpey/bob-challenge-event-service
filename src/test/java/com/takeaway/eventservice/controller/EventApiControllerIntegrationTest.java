package com.takeaway.eventservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.takeaway.eventservice.EventType;
import com.takeaway.eventservice.model.Event;
import com.takeaway.eventservice.service.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventApiControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EventRepository repository;

    private List<Event> events;
    private UUID employeeUuid;

    private ObjectMapper objectMapper;

    @Before
    public void setup(){
        objectMapper = new ObjectMapper();
        mockData();
    }

    @Test
    public void createDepartment_works_fine() throws Exception{
        //when
        ResultActions response = this.mockMvc.perform(get("/v1/events/"+ employeeUuid).contentType(MediaType.APPLICATION_JSON)
                .content("")).andDo(print()).andExpect(status().isOk());

        //then
        List items = objectMapper.readValue(response.andReturn().getResponse().getContentAsString(),events.getClass());
        assertEquals(items, events);
    }

    private void mockData() {
        employeeUuid = UUID.randomUUID();
        List<Event> events = new ArrayList<Event>();
        for(int i= 1; i < 4 ; i++){
            Event event = new Event();
            event.setEventType(EventType.UPDATE);
            event.setCreationDate(LocalDate.now().plusDays(i));
            event.setEmployeeUuid(employeeUuid);
            events.add(event);
            repository.save(event);
        }
        this.events = events;
    }
}
