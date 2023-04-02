package ru.gyurii.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ru.gyurii.springcourse.models.Person;
import ru.gyurii.springcourse.repositories.PeopleRepository;

@Component
public class PersonValidator implements Validator {
    private PeopleRepository peopleRepository;

    @Autowired
    public PersonValidator(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if(peopleRepository.findByName(person.getName()).isPresent()){
            errors.rejectValue("name", "", "Человек с таким именем уже существует.");
        }
    }
}
