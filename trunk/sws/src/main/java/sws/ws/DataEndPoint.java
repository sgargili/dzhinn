package sws.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sws.dto.DataRequest;
import sws.dto.DataResponce;
import sws.model.Person;
import sws.service.DataService;
import sws.service.PersonService;

import javax.xml.bind.JAXBElement;

/**
 * User: Andrey Popov
 * Date: 14.12.10
 * Time: 16:53
 */
@Endpoint
public class DataEndPoint {
    private DataService dataService;

    @Autowired
    public DataEndPoint(DataService dataService) {
        this.dataService = dataService;
    }

    @PayloadRoot(localPart = "dataRequest", namespace = "http://www.persons.pav/data")
//    @ResponsePayload
    public DataResponce getDataResponce(DataRequest dataRequest) {

        System.out.println("sdddd");
//        dataRequest.getValue().setRequestType(0);
//        dataRequest.getValue().setArticle("N00104079026");
        return dataService.getDataResponce(dataRequest);
    }
}
