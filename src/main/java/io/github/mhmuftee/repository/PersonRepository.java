package io.github.mhmuftee.repository;

import io.github.mhmuftee.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    List<Person> findAll();
}
