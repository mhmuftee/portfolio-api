package io.github.mhmuftee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PortfolioController {

    private final PersonRepository repository;

    public PortfolioController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/")
    Person root() {

        List<Person> persons = repository.findAll();

        for (Person p : persons)
            System.out.println(p);

        return persons.get(0);
    }

    // @PostMapping(value ="/")
    //public String addPerson(@RequestBody Person person) {
    //Person p = repository.save(person);
    //   return p.toString();
    //}
}
