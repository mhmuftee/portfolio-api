package io.github.mhmuftee.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, value = {"firstName", "lastName"})
public class PersonDto {
    private String email;
    private String firstName;
    private String lastName;
    private String githubURL;
    private String linkedinURL;
    private String profession;

    public String getName() {return this.firstName + " " + this.lastName;}
}
