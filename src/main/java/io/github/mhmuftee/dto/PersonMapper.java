package io.github.mhmuftee.dto;

import io.github.mhmuftee.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public static PersonDto toPersonDto(Person p) {
        PersonDto pDto = new PersonDto();

        pDto.setEmail(p.getEmail());
        pDto.setFirstName(p.getFirstName());
        pDto.setLastName(p.getLastName());
        pDto.setGithubURL((p.getGithubURL()));
        pDto.setLinkedinURL(p.getLinkedinURL());
        pDto.setProfession(p.getProfession());

        return pDto;
    }
}
