package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.EducationDto;

import java.util.List;

public interface EducationService {
    EducationDto save(EducationDto edu);

    List<EducationDto> getEducationsByPersonId(Long id);

}
