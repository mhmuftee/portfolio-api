package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.PersonDto;
import io.github.mhmuftee.model.Person;
import io.github.mhmuftee.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

@Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private ModelMapper modelMapper;

    public PersonServiceImpl(ModelMapper modelMapper, PersonRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public PersonDto findPerson(Long id) {
        Optional<Person> p = repository.findById(id);

        if (p.isPresent())
            return modelMapper.map(p.get(), PersonDto.class);
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

        return modelMapper.map(p.get(), PersonDto.class);
    }
}
