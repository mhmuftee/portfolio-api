package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.AboutDto;
import io.github.mhmuftee.repository.AboutRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AboutServiceImpl implements AboutService {

    private AboutRepository aboutRepository;
    private ModelMapper modelMapper;

    public AboutServiceImpl(AboutRepository aboutRepository, ModelMapper modelMapper) {
        this.aboutRepository = aboutRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AboutDto findAboutByPersonId(Long id) {
        return modelMapper.map(aboutRepository.findByPersonId(id), AboutDto.class);
    }
}
