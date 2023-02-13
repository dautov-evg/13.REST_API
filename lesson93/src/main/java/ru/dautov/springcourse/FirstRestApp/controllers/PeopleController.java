package ru.dautov.springcourse.FirstRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dautov.springcourse.FirstRestApp.models.Person;
import ru.dautov.springcourse.FirstRestApp.services.PeopleService;
import ru.dautov.springcourse.FirstRestApp.util.PersonErrorResponse;
import ru.dautov.springcourse.FirstRestApp.util.PersonNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> getPeople() {
        return peopleService.findAll(); //Jackson автоматически конвертирует эти объекты в json
    }

    @GetMapping("/{id}")
    public Person getOnePerson(@PathVariable("id") int id) {
        return peopleService.findOne(id);  //Jackson автоматически сконвертирует в json
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this id wasn't found!",
                System.currentTimeMillis()
        );

        // в HTTP ответе тело ответа (response) и статус в заголовке
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // NOT_FOUND - 404 статус
    }
}
