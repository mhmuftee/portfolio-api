package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.SkillDto;

import java.util.List;

public interface SkillService {

    public List<SkillDto> findSkillsByPersonId(Long id);
}
