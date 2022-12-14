package ua.vadym.Api.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.vadym.Api.models.Person;
import ua.vadym.Api.service.PersonService;
import ua.vadym.Api.util.PersonErrorResponse;
import ua.vadym.Api.util.PersonNotFoundException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PersonService personService;
    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping
    public List<Person> getPeople() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
    return personService.findOne(id);
    }
    @GetMapping("/{name}")
    List<Person> getAllByName(@PathVariable String name) {
        return personService.getPersonByName(name);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException exception) {
        PersonErrorResponse personErrorResponse = new PersonErrorResponse(
                "Person with id wasn't found", LocalDate.now()
        );

        return new ResponseEntity<>(personErrorResponse, HttpStatus.NOT_FOUND);
    }

}
