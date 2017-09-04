package com.frankmoley.talks.swagger.webservice;

import com.frankmoley.talks.swagger.service.Person;
import com.frankmoley.talks.swagger.service.PersonTaskService;
import com.frankmoley.talks.swagger.service.PersonalTasks;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Frank P. Moley III.
 */
@RestController
@Api(value="Personal Tasks Services", description = "Services to work with people and their tasks")
public class TaskController {
    private PersonTaskService service;

    @Autowired
    public TaskController(PersonTaskService service) {
        this.service = service;
    }

    @GetMapping("/people")
    @ApiOperation(value = "get all people")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "Bad Reqeust")
    })
    public Map<Long, String> getPeople(){
        return this.service.getPersonMap();
    }

    @PostMapping("/people")
    @ApiOperation(value="add person")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "Bad Reqeust")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalTasks addPerson(Person person){
        return this.service.addPerson(person);
    }

    @GetMapping("people/{id}")
    @ApiOperation(value="get person and tasks")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "Bad Reqeust")
    })
    public PersonalTasks getPerson(@PathVariable long id){
        return this.service.getPersonalTasks(id);
    }
}
