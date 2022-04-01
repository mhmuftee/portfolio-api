package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.SkillDto;
import io.github.mhmuftee.repository.SkillRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private ModelMapper modelMapper;

    public SkillServiceImpl(ModelMapper modelMapper, SkillRepository skillRepository) {
        this.modelMapper = modelMapper;
        this.skillRepository = skillRepository;
    }

    @Override
    public List<SkillDto> findSkillsByPersonId(Long id) {
        return skillRepository.findByPersonId(id).stream()
                .map(skill -> modelMapper.map(skill, SkillDto.class)).collect(Collectors.toList());
    }
}
