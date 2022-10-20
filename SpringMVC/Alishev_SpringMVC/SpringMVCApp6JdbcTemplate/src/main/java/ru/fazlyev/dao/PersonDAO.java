package ru.fazlyev.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.fazlyev.models.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class PersonDAO {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // read список всех сущностей из person
    public List<Person> index() {
        return jdbcTemplate.query("select * from person ", new BeanPropertyRowMapper<>(Person.class));
    }

    // read по Id  в  таблице person
    public Person show(int id) {
        return jdbcTemplate.query("select * from Person where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);

    }

    //create new Person в БД таблице person
    public void save(Person person) {
        jdbcTemplate.update("insert  into  person values (1,?,?,?)",person.getName(), person.getAge(), person.getEmail());
    }


    //update в БД в  таблице person
    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("update person set  name=?,age=?,email=? where id =?",
                updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(),id);

    }

    //delete в БД  в  таблице person
    public void delete(int id) {
        jdbcTemplate.update("delete from person where id =?",id);
    }

}
