package spring.env.dao;

import org.springframework.stereotype.Component;
import spring.env.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO
{
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "savenkova";

    private static Connection connection;

    static
    {
        try
        {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try
        {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public List<Person> index()
    {
        List<Person> people = new ArrayList<>();

        try
        {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resulSet = statement.executeQuery(SQL);

            while(resulSet.next())
            {
                Person person = new Person();

                person.setId(resulSet.getInt("id"));
                person.setName(resulSet.getString("name"));
                person.setAge(resulSet.getInt("age"));
                person.setEmail(resulSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return people;
    }

    public Person show(int id)
    {
        return null;
        /*return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);*/
    }

    public void save(Person person)
    {
        try
        {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES("
                    + 1 + ",'" + person.getName()
                    + "'," + person.getAge() + ",'"
                    + person.getEmail() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person updatedPerson)
    {
        /*Person personToUpdate = show(id);

        personToUpdate.setName(updatedPerson.getName());
        personToUpdate.setAge(updatedPerson.getAge());
        personToUpdate.setEmail(updatedPerson.getEmail());*/
    }

    public void delete(int id)
    {
        /*people.removeIf(person -> person.getId() == id);*/
    }
}
