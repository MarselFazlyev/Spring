package ru.fazlyev.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.fazlyev.models.Book;


import java.lang.management.OperatingSystemMXBean;
import java.util.List;

@Component
public class BookDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("select * from book",new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book) {
         jdbcTemplate.update("insert into book (title,author,year_of_release) values (?,?,?)",
             book.getTitle(),book.getAuthor(),book.getYear_of_release());
    }

    public Book showBook (int id) {
        return jdbcTemplate.query("select * from book where id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public  List<Book> returnBooksByPersonId(int id) {
        return jdbcTemplate.
                query("select * from book where" +
                " owner_id = ?",new Object[]{id},new BeanPropertyRowMapper<>(Book.class));
    }

    public void freeBook(int id){
        jdbcTemplate.update("update book set owner_id = null where id=?",id);
    }
}
