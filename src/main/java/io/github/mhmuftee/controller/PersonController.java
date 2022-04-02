package io.github.mhmuftee.controller;

import io.github.mhmuftee.dto.*;
import io.github.mhmuftee.service.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin(value = {"https://mhmuftee.github.io/"})
public class PersonController {


    private final PersonService personService;
    private final ExperienceService experienceService;
    private final EducationService educationService;
    private final SkillService skillService;
    private final AboutService aboutService;

    public PersonController(PersonService personService, ExperienceService experienceService, EducationService educationService, SkillService skillService, AboutService aboutService) {
        this.personService = personService;
        this.experienceService = experienceService;
        this.educationService = educationService;
        this.skillService = skillService;
        this.aboutService = aboutService;
    }

    @GetMapping(value = "/person")
    public PersonDto getPerson() {
        return personService.findPerson(getPersonId());
    }

    @PostMapping(value = "/person")
    public String addPerson(@RequestBody @Valid PersonDto personDto) {
        //personService.save(personDto);
        return "done";
    }

    @GetMapping(value = "/education")
    public List<EducationDto> getEducations() {
        return educationService.getEducationsByPersonId(getPersonId());
    }

    @PostMapping(value = "/education")
    public String addEducation(@RequestBody @Valid EducationDto educationDto) {
        //educationService.save(educationDto);
        return "done";
    }

    @GetMapping(value = "/experience")
    public List<ExperienceDto> getExperiences() {
        return experienceService.getExperienceByPersonId(getPersonId());
    }

    @GetMapping(value = "/skills")
    public List<SkillDto> getSkills() {
        return skillService.findSkillsByPersonId(getPersonId());
    }

    @GetMapping(value = "/about")
    public AboutDto getAbout() {
        return aboutService.findAboutByPersonId(getPersonId());
    }

    private Long getPersonId() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return personService.getPersonId(user.getUsername());
    }
}
