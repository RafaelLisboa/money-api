package br.com.rafael.moneyapi.service;

import br.com.rafael.moneyapi.model.Person;
import br.com.rafael.moneyapi.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person update(Long id, Person person) {
        Optional<Person> savedPerson = personRepository.findById(id);
        if (savedPerson.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(person, savedPerson.get(), "id");
        return personRepository.save(savedPerson.get());
    }

    public Optional<Person> getById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return person;
    }

}
