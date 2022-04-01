package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.ExperienceDto;

import java.util.List;

public interface ExperienceService {
    List<ExperienceDto> getExperienceByPersonId(Long id);
}
