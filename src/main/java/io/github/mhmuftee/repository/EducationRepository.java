package io.github.mhmuftee.repository;

import io.github.mhmuftee.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface EducationRepository extends JpaRepository<Education, Long> {
    Collection<Education> findByPersonId(Long person_id);
}
