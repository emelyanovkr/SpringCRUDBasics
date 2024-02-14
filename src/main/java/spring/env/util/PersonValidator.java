package spring.env.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import spring.env.dao.PersonDAO;
import spring.env.models.Person;

@Component
public class PersonValidator implements Validator
{
    private final PersonDAO personDAO;

    public PersonValidator(PersonDAO personDAO)
    {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Person person = (Person) target;

        if(personDAO.show(person.getEmail()).isPresent())
        {
            errors.rejectValue("email","", "Email is already taken");
        }
    }
}
