package io.github.mhmuftee.service;

import io.github.mhmuftee.dto.AboutDto;

public interface AboutService {
    AboutDto findAboutByPersonId(Long id);
}
