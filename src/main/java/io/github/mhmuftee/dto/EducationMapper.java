package io.github.mhmuftee.dto;

import io.github.mhmuftee.model.Education;
import io.github.mhmuftee.model.Institution;
import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.stream.Collectors;

public class EducationMapper {

    static InstitutionDto toInstituteDto(Institution i) {
        return (i == null)
                ? new InstitutionDto()
                : new InstitutionDto()
                .setLocation(i.getLocation())
                .setCountry(i.getCountry())
                .setName(i.getName())
                .setUrl(i.getUrl());
    }

    public static EducationDto toEducationDto(Education e) {

        return new EducationDto()
                .setDegreeName(e.getDegreeName())
                .setEndTime(e.getEndTime())
                .setStartTime(e.getStartTime())
                .setInstitution(toInstituteDto(e.getInstitution()))
                .setCourses(new HashSet<>(
                        e.getCourses()
                                .stream()
                                .map(course -> new ModelMapper().map(course, CourseDto.class))
                                .collect(Collectors.toSet())));
    }
}
