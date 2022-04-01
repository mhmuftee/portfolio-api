package io.github.mhmuftee.repository;

import io.github.mhmuftee.model.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<About, Long> {
    About findByPersonId(Long id);
}