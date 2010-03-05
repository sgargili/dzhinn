package endpoint;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;
import org.springframework.ws.server.endpoint.AbstractJDomPayloadEndpoint;

import service.EchoService;

public class EchoEndpoint extends AbstractJDomPayloadEndpoint {

    private EchoService echoService;

    public void setEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    protected Element invokeInternal(Element request) throws Exception {
        // ok now we have the XML document from the web service request
        // lets system.out the XML so we can see it on the console (log4j
        // latter)
        System.out.println("XML Doc >> ");
        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(request, System.out);

        // I am using JDOM for my example....feel free to process the XML in
        // whatever way you best deem right (jaxb, castor, sax, etc.)

        // some jdom stuff to read the document
        Namespace namespace = Namespace.getNamespace("ec",
                "http://www.averconsulting.com/echo/schemas");
        XPath nameExpression = XPath.newInstance("//ec:Name");
        nameExpression.addNamespace(namespace);

        // lets call a backend service to process the contents of the XML
        // document
        String name = nameExpression.valueOf(request);
        String msg = echoService.echo(name);

        // build the response XML with JDOM
        Namespace echoNamespace = Namespace.getNamespace("ec",
                "http://www.averconsulting.com/echo/schemas");
        Element root = new Element("EchoResponse", echoNamespace);
        Element echoResponse = new Element("EchoResponse", echoNamespace);
        root.addContent(echoResponse);
        Element message = new Element("Message", echoNamespace);
        echoResponse.addContent(message);
        message.setText(msg);
        Document doc = new Document(root);

        // return response XML
        System.out.println();
        System.out.println("XML Response Doc >> ");
        xmlOutputter.output(doc, System.out);
        return doc.getRootElement();
    }
}
