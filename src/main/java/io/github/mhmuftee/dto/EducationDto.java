package io.github.mhmuftee.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class EducationDto {
    private InstitutionDto institution;
    private String degreeName;
    private String startTime;
    private String endTime;
    private String subject;
    private Set<CourseDto> courses;
}
