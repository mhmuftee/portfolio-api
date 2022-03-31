package io.github.mhmuftee.controller;

import io.github.mhmuftee.dto.EducationDto;
import io.github.mhmuftee.dto.PersonDto;
import io.github.mhmuftee.service.EducationService;
import io.github.mhmuftee.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin("https://mhmuftee.github.io")
public class PersonController {


    private final PersonService personService;
    private final EducationService educationService;

    public PersonController(PersonService personService, EducationService educationService) {
        this.personService = personService;
        this.educationService = educationService;
    }

    @GetMapping(value = "")
    public PersonDto getPerson(@RequestBody PersonDto personDto) {
        return personService.findPerson(personDto.getEmail());
    }

    @PostMapping(value = "")
    public String addPerson(@RequestBody @Valid PersonDto personDto) {
        //personService.save(personDto);
        return "done";
    }

    @PostMapping(value = "/education")
    public String addEducation(@RequestBody @Valid EducationDto educationDto) {
        //educationService.save(educationDto);
        return "done";
    }

    @GetMapping(value = "/education")
    public List<EducationDto> getEducations(@RequestBody @Valid PersonDto personDto) {
        Long id = personService.getPersonId(personDto.getEmail());
        return educationService.getEducationsByPersonId(id);
    }
}
