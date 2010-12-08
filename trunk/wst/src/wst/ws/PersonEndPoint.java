package wst.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import wst.model.Person;
import wst.service.PersonService;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;

/**
 * User: Andrey Popov
 * Date: 08.12.2010
 * Time: 16:30:06
 */
@Endpoint
public class PersonEndPoint {
    private final PersonService personService;

    @Autowired
    public PersonEndPoint(PersonService personService) {
        this.personService = personService;
    }

    @PayloadRoot(localPart = "", namespace = "")
    @ResponsePayload
    public Person getPerson(@RequestPayload Element requestElement) {
        Person person = personService.getPersonById(12);
        return person;
    }
}
