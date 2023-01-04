package ru.fazlyev.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.fazlyev.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public void save(Person person) {
        jdbcTemplate.update("insert into person (full_name,year) values (?,?)", person.getFull_name(),
                person.getYear());
    }

    public void update(int id,Person person) {
        jdbcTemplate.update("update person set (full_name,year) values (?,?) where id=?", person.getFull_name(),
                person.getYear(),id);
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from person where id =?",id);
    }

    public Person showPerson(int id){
        return jdbcTemplate.query("select * from person where id = ?",new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream()
                .findAny().orElse(null);
    }


}
