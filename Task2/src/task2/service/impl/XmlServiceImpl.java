package task2.service.impl;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import task2.model.Computer;
import task2.model.Computers;
import task2.model.Equipment;
import task2.model.Hardware;
import task2.service.XmlService;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class XmlServiceImpl extends DefaultHandler implements XmlService {
    private Equipment equipment;
	private Hardware hardware;
	private Computer computer;
	private Computers computers;

    private boolean isCpu, isSoundCard, isHdd, isSoftware;

    public Equipment getInformationFromXml() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("task2/resources/equipment.xml");
        try {
	        if (parser != null) {
		        parser.parse(inputStream, this);
	        }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return equipment;    // проверить вывод!!!!!!!!!!!
    }

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("equipment")) {
            equipment = new Equipment();
        }

        if (qName.equals("computers")) {
            computers = new Computers();
        }

	    if (qName.equals("computer")) {
		    computer = new Computer();
		    computer.setId(Integer.parseInt(attributes.getValue("id")));
	    }


	    if (qName.equals("hardware")) {
		    hardware = new Hardware();
	    }

	    if (qName.equals("cpu")) {
		    isCpu = true;
	    }
	    if (qName.equals("soundcard")) {
		    isSoundCard = true;
	    }
	    if (qName.equals("hdd")) {
		    isHdd = true;
	    }

        if (qName.equals("software")) {
            isSoftware = true;
        }

    }


	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length);

		if (isCpu) {
			hardware.setCpu(data);
		}
		if (isSoundCard) {
			hardware.setSoundcard(data);
		}
		if (isHdd) {
			hardware.setHdd(data);
		}
		if (isSoftware) {
			computer.setSoftware(data);
		}

	}


    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("computers")) {
            equipment.setComputers(computers);
        }

        if (qName.equals("computer")) {
	        computers.addComputer(computer);

        }

	    if (qName.equals("hardware")) {
	        computer.setHardware(hardware);

        }
        if (qName.equals("software")) {
           isSoftware = false;
        }
        if (qName.equals("cpu")) {
            isCpu = false;
        }

        if (qName.equals("hdd")) {
            isHdd = false;
        }
        if (qName.equals("soundcard")) {
            isSoundCard = false;
        }

    }


}

