package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.EducationDto;
import io.github.mhmuftee.model.Education;
import io.github.mhmuftee.repository.EducationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private ModelMapper modelMapper;

    public EducationServiceImpl(ModelMapper modelMapper, EducationRepository educationRepository) {
        this.modelMapper = modelMapper;
        this.educationRepository = educationRepository;
    }

    @Override
    @Transactional
    public EducationDto save(EducationDto educationDto) {

        Education education = new Education()
                .setEndTime(educationDto.getEndTime())
                .setStartTime(educationDto.getStartTime())
                .setDegreeName(educationDto.getDegreeName())
                .setSubject(educationDto.getSubject())
                .setCourses(new ArrayList<>());

        Optional<Education> edu = Optional.ofNullable(educationRepository.save(education));

        return modelMapper.map(education, EducationDto.class);
    }

    @Override
    public List<EducationDto> getEducationsByPersonId(Long id) {
        return educationRepository
                .findByPersonId(id)
                .stream()
                .map(education -> modelMapper.map(education, EducationDto.class))
                .collect(Collectors.toList());
    }
}
