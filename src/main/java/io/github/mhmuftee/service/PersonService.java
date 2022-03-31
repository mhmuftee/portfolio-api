package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.PersonDto;

public interface PersonService {

    PersonDto findPerson(String email);

    Long getPersonId(String email);

    PersonDto save(PersonDto person);
}
