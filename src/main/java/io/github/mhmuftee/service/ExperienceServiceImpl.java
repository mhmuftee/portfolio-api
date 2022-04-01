package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.ExperienceDto;
import io.github.mhmuftee.repository.ExperienceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private ModelMapper modelMapper;

    public ExperienceServiceImpl(ModelMapper modelMapper, ExperienceRepository experienceRepository) {
        this.modelMapper = modelMapper;
        this.experienceRepository = experienceRepository;
    }

    @Override
    public List<ExperienceDto> getExperienceByPersonId(Long id) {
        return experienceRepository
                .findByPersonId(id)
                .stream()
                .map(experience -> modelMapper.map(experience, ExperienceDto.class))
                .collect(Collectors.toList());
    }
}
