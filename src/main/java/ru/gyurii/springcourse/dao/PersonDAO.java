package ru.gyurii.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.gyurii.springcourse.models.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PersonDAO {

    private static int PERSON_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PERSON_COUNT,"user1", new Date(10, 0, 1)));
        people.add(new Person(++PERSON_COUNT,"user2",new Date(20, 1, 2)));
        people.add(new Person(++PERSON_COUNT,"user3", new Date(30, 2, 3)));
        people.add(new Person(++PERSON_COUNT,"user4", new Date(40, 3, 3)));
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

    public void save(Person person){
        person.setId(++PERSON_COUNT);
        people.add(person);
    }

    public void update(int id, Person person){
        Person personToUpdate = show(id);
        personToUpdate.setName(person.getName());
        personToUpdate.setBirthday(person.getBirthday());
    }
}
