package mvc.service.impl;

import mvc.model.Person;
import mvc.service.PersonService;

/**
 * User: Andrey Popov
 * Date: 08.12.2010
 * Time: 16:27:32
 */
public class PersonServiceImpl implements PersonService {
    public Person getPersonById(int id) {
        Person person = new Person();
        person.setId(id);
        person.setAge(27);
        person.setName("Andrey");
        person.setSurname("Popov");
        return person;
    }
}
