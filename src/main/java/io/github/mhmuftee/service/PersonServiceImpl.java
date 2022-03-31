package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.PersonDto;
import io.github.mhmuftee.dto.PersonMapper;
import io.github.mhmuftee.model.Person;
import io.github.mhmuftee.repository.PersonRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

@Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonDto findPerson(String email) {
        Optional<Person> p = Optional.ofNullable(repository.findByEmail(email));

        if (p.isPresent())
            return PersonMapper.toPersonDto(p.get());
        else
            throw new RuntimeException("user not found");
    }

    @Override
    public Long getPersonId(String email) {
        Optional<Person> p = Optional.ofNullable(repository.findByEmail(email));

        if (p.isPresent())
            return p.get().getId();

        else
            throw new RuntimeException("user not found");
    }

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        Person person = new Person()
                .setEmail(personDto.getEmail())
                .setFirstName((personDto.getFirstName()))
                .setLastName(personDto.getLastName())
                .setGithubURL(personDto.getGithubURL())
                .setLinkedinURL(personDto.getLinkedinURL())
                .setProfession(personDto.getProfession())
                .setEducations(new HashSet<>());

        Optional<Person> p = Optional.ofNullable(repository.save(person));

        return PersonMapper.toPersonDto(p.get());
    }
}
