package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.PersonDto;
import io.github.mhmuftee.dto.PersonMapper;
import io.github.mhmuftee.model.Person;
import io.github.mhmuftee.repository.PersonRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public PersonDto findPerson() {
        Optional<Person> p = Optional.ofNullable(repository.findAll().get(0));
        if (p.isPresent())
            return PersonMapper.toPersonDto(p.get());
        else
            throw new RuntimeException("user not found");
    }
}
