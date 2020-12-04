/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.17).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.takeaway.eventservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Events;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-04T10:09:05.546Z")

@Api(value = "events", description = "the events API")
@RequestMapping(value = "/v1")
public interface EventsApi {

    @ApiOperation(value = "Find all Events by Employee UUID", nickname = "getEventsByEmployeeUuid", notes = "Returns All Events", response = Events.class, tags={ "event", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Events.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found") })
    @RequestMapping(value = "/events/{employeeUuid}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Events> getEventsByEmployeeUuid(@ApiParam(value = "UUID of employee to return events",required=true) @PathVariable("employeeUuid") String employeeUuid);

}
