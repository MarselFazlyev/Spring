package ru.fazlyev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.fazlyev.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    // read список всех сущностей из person
    @Transactional
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> people = session.createSelectionQuery("from Person", Person.class).getResultList();
        return people;
    }

    // read по Id  в  таблице person
    public Person show(int id) {
        return null;

    }

    //create new Person в БД таблице person
    public void save(Person person) {

    }


    //update в БД в  таблице person
    public void update(int id, Person updatedPerson) {


    }

    //delete в БД  в  таблице person
    public void delete(int id) {

    }

}
