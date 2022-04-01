package io.github.mhmuftee.repository;

import io.github.mhmuftee.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByPersonId(Long id);
}