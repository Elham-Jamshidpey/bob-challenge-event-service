package com.takeaway.eventservice.service;

import com.takeaway.eventservice.model.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventBizServiceTest {

    @Autowired
    private EventBizService service;

    @MockBean
    private EventDataService eventDataService;

    private List<Event> events;

    private UUID employeeUuid;

    @Before
    public void setup() {
        mockData();
    }

    @Test
    public void findAllByEmployeeUuid_works_fine(){
        //given
        Mockito.when(eventDataService.findAllByEmployeeUuid(any(UUID.class))).thenReturn(Optional.of(events));

        //when
        List<Event> events = service.findAllByEmployeeUuid(employeeUuid);

        //then
        assertEquals(events,this.events);
    }

    private void mockData() {
        employeeUuid = UUID.randomUUID();
        List<Event> events = new ArrayList<Event>();
        for(int i= 1; i < 4 ; i++){
           Event event = new Event();
           event.setAction("UPDATE");
           event.setCreationDate(LocalDate.now().plusDays(i));
           event.setEmployeeUuid(employeeUuid);
           events.add(event);
        }
        this.events = events;
    }
}
