/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint;

import message.HumanRequest;
import message.HumanResponse;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;
import service.HumanManager;
import types.Human;

/**
 *
 * @author APopov
 */
public class GetHumanEndpoint extends AbstractMarshallingPayloadEndpoint {

    private HumanManager humanManager;

    public void setHm(HumanManager hm) {
        this.humanManager = hm;
    }

    @Override
    protected Object invokeInternal(Object requestObject) throws Exception {
        HumanRequest request = (HumanRequest) requestObject;
        Human human = humanManager.getHumanById(request.getId());
        HumanResponse response = new HumanResponse(human);
        return response;
    }
}
