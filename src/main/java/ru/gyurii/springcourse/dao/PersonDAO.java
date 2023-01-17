package ru.gyurii.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.gyurii.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PERSON_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PERSON_COUNT,"user1", 1970));
        people.add(new Person(++PERSON_COUNT,"user2",1989));
        people.add(new Person(++PERSON_COUNT,"user3", 1990));
        people.add(new Person(++PERSON_COUNT,"user4", 2000));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(people-> people.getId() == id)
                .findAny()
                .orElse(null);
    }
}
