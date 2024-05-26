package ru.ilinykh.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ilinykh.springcourse.models.Book;
import ru.ilinykh.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new PersonMapper());
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE person_id=?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE person set full_name=?, age=? where person_id=?",
                updatedPerson.getFullName(), updatedPerson.getAge(), updatedPerson.getId());
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(full_name, age) values (?, ?)", person.getFullName(), person.getAge());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE person_id=?", id);
    }

    public List<Book> getBooksByPersonId(int id){
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id=?", new Object[]{id}, new BookMapper());
    }
}
