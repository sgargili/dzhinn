package tr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Администратор creates on 29.04.12 (13:34)
 */
public class Persons {
    private List<Person> persons = new ArrayList<Person>();

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }


}
