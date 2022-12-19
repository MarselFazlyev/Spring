package ru.fazlyev.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fazlyev.FirstSecurityApp.models.Person;

import java.util.Optional;

public interface PeopleRepo extends JpaRepository<Person,Integer> {

    Optional<Person> findByUserName(String userName);
}
