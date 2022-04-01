package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.PersonDto;

public interface PersonService {

    PersonDto findPerson(Long id);

    Long getPersonId(String email);

    PersonDto save(PersonDto person);
}
