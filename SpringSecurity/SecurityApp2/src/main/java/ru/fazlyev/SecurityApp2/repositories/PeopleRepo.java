package ru.fazlyev.SecurityApp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fazlyev.SecurityApp2.models.Person;

import java.util.Optional;

public interface PeopleRepo extends JpaRepository<Person,Integer> {

    Optional<Person> findByUserName(String userName);
}
