package ru.gyurii.springcourse.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.gyurii.springcourse.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("people_id"));
        person.setName(rs.getString("name"));
        person.setBirthday(rs.getDate("birthday"));

        return person;
    }
}
