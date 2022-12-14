package ua.vadym.Api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vadym.Api.models.Person;
import ua.vadym.Api.repository.PersonRepository;
import ua.vadym.Api.util.PersonNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> findAll() {
        return personRepository.findAll();
    }


    public Person findOne(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElseThrow(PersonNotFoundException::new);
    }


    public List<Person> getPersonByName(String name) {
        return personRepository.getAllByAge(name);
    }

}
