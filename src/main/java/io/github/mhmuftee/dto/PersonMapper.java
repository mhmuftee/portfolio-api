package io.github.mhmuftee.dto;

import io.github.mhmuftee.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public static PersonDto toPersonDto(Person p) {
        return new PersonDto()
                .setEmail(p.getEmail())
                .setFirstName(p.getFirstName())
                .setLastName(p.getLastName())
                .setGithubURL((p.getGithubURL()))
                .setLinkedinURL(p.getLinkedinURL())
                .setProfession(p.getProfession())
                ;
    }
}
