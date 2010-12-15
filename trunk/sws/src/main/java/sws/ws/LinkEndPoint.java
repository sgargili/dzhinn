package sws.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import sws.dto.DataRequest;
import sws.dto.DataResponce;
import sws.dto.LinkRequest;
import sws.dto.LinkResponce;
import sws.service.DataService;
import sws.service.LinkService;

/**
 * User: Andrey Popov
 * Date: 15.12.10
 * Time: 13:16
 */
@Endpoint
public class LinkEndPoint {
    private LinkService linkService;

    @Autowired
    public LinkEndPoint(LinkService linkService) {
        this.linkService = linkService;
    }

    @PayloadRoot(localPart = "linkRequest", namespace = "http://www.persons.pav/link")
    public LinkResponce getLinkResponce(LinkRequest linkRequest) {
        return linkService.getLinkResponce(linkRequest);
    }
}
