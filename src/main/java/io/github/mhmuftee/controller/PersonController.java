package io.github.mhmuftee.controller;

import io.github.mhmuftee.dto.PersonDto;
import io.github.mhmuftee.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {


    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/")
    public PersonDto getPerson() {
        return personService.findPerson();
    }

    // @PostMapping(value ="/")
    //public String addPerson(@RequestBody Person person) {
    //Person p = repository.save(person);
    //   return p.toString();
    //}
}
