package ait.cohort55.person.dao;

import ait.cohort55.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Set;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Set<Person> findByNameIgnoreCase(String name);

    Set<Person> findByAddressCityIgnoreCase(String city);

    Set<Person> findByBirthDateBetween(LocalDate from, LocalDate to);
}
