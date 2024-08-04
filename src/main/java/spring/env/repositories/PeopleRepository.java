package spring.env.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.env.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>
{
  List<Person> findByName(String name);

  List<Person> findByNameOrderByAge(String name);

  List<Person> findByEmail(String email);

  List<Person> findByNameStartingWith(String name);

  List<Person> findByNameOrEmail(String name, String email);
}
