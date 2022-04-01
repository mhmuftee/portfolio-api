package io.github.mhmuftee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class EducationDto {
    private InstitutionDto institution;
    private String degreeName;
    private String startTime;
    private String endTime;
    private String subject;
    private List<CourseDto> courses;
}
