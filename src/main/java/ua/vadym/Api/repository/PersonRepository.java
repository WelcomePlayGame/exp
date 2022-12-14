package ua.vadym.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.vadym.Api.models.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


    List<Person> getAllByAge(String name);

}
