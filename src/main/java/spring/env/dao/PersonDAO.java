package spring.env.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.env.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO
{
  private final SessionFactory sessionFactory;

  @Autowired
  public PersonDAO(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }

  @Transactional(readOnly = true)
  public List<Person> index()
  {
    Session session = sessionFactory.getCurrentSession();

    return session.createQuery("from Person", Person.class).getResultList();
  }

  @Transactional(readOnly = true)
  public Person show(int id)
  {
    Session session = sessionFactory.getCurrentSession();

    return session.get(Person.class, id);
  }

  @Transactional
  public void save(Person person)
  {
    Session session = sessionFactory.getCurrentSession();
    session.persist(person);
  }

  @Transactional
  public void update(int id, Person updatedPerson)
  {
    Session session = sessionFactory.getCurrentSession();
    Person person = session.get(Person.class, id);

    person.setName(updatedPerson.getName());
    person.setAge(updatedPerson.getAge());
    person.setEmail(updatedPerson.getEmail());
    session.merge(person);
  }

  @Transactional
  public void delete(int id)
  {
    Session session = sessionFactory.getCurrentSession();
    session.remove(session.get(Person.class, id));
  }

  //////////////////////////
  //// TEST ENVIRONMENT ////
  //////////////////////////

  public void testMultipleUpdate()
  {
    List<Person> people = create1000People();

    long before = System.currentTimeMillis();

    for (Person person : people)
    {
      // Insert people
    }

    long after = System.currentTimeMillis();

    System.out.println("MULTIPLE: " + (after - before));
  }

  public void testBatchUpdate()
  {
    List<Person> people = create1000People();

    long before = System.currentTimeMillis();

    for (Person person : people)
    {
            /*jdbcTemplate.batchUpdate("INSERT INTO Person VALUES(?, ?, ?, ?)",
                    new BatchPreparedStatementSetter()
                    {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException
                        {
                            ps.setInt(1, i);
                            ps.setString(2, people.get(i).getName());
                            ps.setInt(3, people.get(i).getAge());
                            ps.setString(4, people.get(i).getEmail());
                        }

                        @Override
                        public int getBatchSize()
                        {
                            return people.size();
                        }
                    });*/
    }

    long after = System.currentTimeMillis();
    System.out.println("BUTCH: " + (after - before));
  }


  private List<Person> create1000People()
  {
    List<Person> people = new ArrayList<>();

    for (int i = 0; i < 1000; ++i)
    {
      // people.add(new Person(i, "Name" + i, 30, "test" + i + "@mail.ru", "some address"));
    }

    return people;
  }
}
