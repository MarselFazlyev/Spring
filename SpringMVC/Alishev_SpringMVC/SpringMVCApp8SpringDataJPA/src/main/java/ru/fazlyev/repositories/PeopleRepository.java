package ru.fazlyev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fazlyev.models.Person;

public interface PeopleRepository extends JpaRepository<Person,Integer> {

}
