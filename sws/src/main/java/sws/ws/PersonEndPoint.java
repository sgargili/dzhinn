package sws.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.ws.server.endpoint.PayloadEndpoint;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sws.dto.DataRequest;
import sws.dto.DataResponce;
import sws.model.Person;
import sws.service.PersonService;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;

/**
 * User: Andrey Popov
 * Date: 08.12.2010
 * Time: 16:30:06
 */
//@Endpoint
public class PersonEndPoint {
    private final PersonService personService;

//    @Autowired
    public PersonEndPoint(PersonService personService) {
        this.personService = personService;
    }


//    @PayloadRoot(localPart = "personRequest", namespace = "http://www.persons.pav/persons")
//    @ResponsePayload
    public Person getPerson(Person person) {
        Person per = personService.getPersonById(person.getId());
        return per;
    }


}
