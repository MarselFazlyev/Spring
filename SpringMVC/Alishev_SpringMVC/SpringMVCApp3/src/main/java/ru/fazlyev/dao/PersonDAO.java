package ru.fazlyev.dao;

import org.springframework.stereotype.Component;
import ru.fazlyev.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    //имитация id в БД
    private static int PEOPLE_COUNT;

    //имитация таблицы людей в БД
    private List<Person> people;

    {people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom"));
        people.add(new Person(++PEOPLE_COUNT,"Bob"));
        people.add(new Person(++PEOPLE_COUNT,"Mike"));
        people.add(new Person(++PEOPLE_COUNT,"Katy"));

    }

    // read список всех сущностей
    public List<Person> index (){
        return people;
    }

    // read по Id
    public Person show(int id){
        return people.stream().filter(person -> person.getId() ==id).findAny().orElse(null);
    }

    //create new Person в  имитацию БД people
    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    //update в БД
    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    //delete в БД
    public void delete(int id){
        people.removeIf(person -> person.getId()==id);
    }

}
