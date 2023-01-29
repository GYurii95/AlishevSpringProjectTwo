package ru.gyurii.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gyurii.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT *FROM People", new PersonMapper());
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT *FROM People WHERE people_id=?",
                new Object[]{id}, new PersonMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO People(name, birthday) VALUES (?, ?)",
                person.getName(),
                person.getBirthday());
    }

    public void update(int id, Person person){
        jdbcTemplate.update("UPDATE People SET name=?, birthday=? WHERE people_id=?",
                person.getName(),
                person.getBirthday(),
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM People WHERE people_id=?", id);
    }
}
