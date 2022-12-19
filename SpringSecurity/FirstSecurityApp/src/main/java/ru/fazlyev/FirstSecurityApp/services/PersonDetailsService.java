package ru.fazlyev.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.fazlyev.FirstSecurityApp.models.Person;
import ru.fazlyev.FirstSecurityApp.repositories.PeopleRepo;
import ru.fazlyev.FirstSecurityApp.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private PeopleRepo peopleRepo;

    @Autowired
    public PersonDetailsService (PeopleRepo peopleRepo){
        this.peopleRepo = peopleRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person =  peopleRepo.findByUserName(username);
        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return new PersonDetails(person.get());
    }
}
