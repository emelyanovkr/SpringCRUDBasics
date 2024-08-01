package spring.env.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "person")
public class Person
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotEmpty(message = "Name can't be empty")
  @Size(min = 2, max = 30, message = "Wrong name length")
  @Column(name = "name")
  private String name;

  @Min(value = 0, message = "Age can't be negative")
  @Column(name = "age")
  private int age;

  @NotEmpty(message = "Email can't be empty")
  @Email
  @Column(name = "email")
  private String email;

  public Person()
  {
  }

  public Person(int id, String name, int age)
  {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }
  
  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }
}
