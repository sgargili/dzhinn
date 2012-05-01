package tr.service.impl;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import tr.service.XmlService;
import tr.model.Person;
import tr.model.Persons;

/**
 * @author Администратор creates on 29.04.12 (13:35)
 */
public class XmlServiceImpl extends DefaultHandler implements XmlService {

    private Persons persons;
    private Person person;
    private boolean isName, isSurname, isAge;

    public Persons getPersonsFromXml() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        File file = new File("e://person.xml");
        try {
            parser.parse(file, this);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("persons")) {
            persons = new Persons();
        }
        if (qName.equals("person")) {
            person = new Person();
        }
        if (qName.equals("name")) {
            isName = true;
        }
        if (qName.equals("surname")) {
            isSurname = true;
        }
        if (qName.equals("age")) {
            isAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
        if (qName.equals("person")) {
            persons.addPerson(person);
        }
        if (qName.equals("name")) {
            isName = false;
        }
        if (qName.equals("surname")) {
            isSurname = false;        }
        if (qName.equals("age")) {
            isAge = false;        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        if(isName){
            person.setName(data);
        }
        if(isSurname){
            person.setSurname(data);
        }
        if(isAge){
            person.setAge(Integer.parseInt(data));
        }
    }
}
