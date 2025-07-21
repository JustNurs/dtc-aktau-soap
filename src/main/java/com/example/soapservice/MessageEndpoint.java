package com.example.soapservice;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MessageEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/soapservice";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "data")
    @ResponsePayload
    public GetResponse handleMessage(@RequestPayload Data request) {
        ObjectFactory factory = new ObjectFactory();
        GetResponse response = factory.createGetResponse();
        ResponseDataType responseData = factory.createResponseDataType();
        ResponseMessage responseMessage = factory.createResponseMessage();

        responseMessage.setSender("POA");
        responseMessage.setRecipient("DTC");
        responseMessage.setMessageType("DONE");
        responseMessage.setMsgid(request.getMessage().getHeader().getMessageId());

        responseData.setMessage(responseMessage);
        response.setData(responseData);
        return response;
    }
}
