package com.example.soapservice;

import com.example.soapservice.expbol.EXPBOLRequest;
import com.example.soapservice.expbol.EXPBOLResponse;
import com.example.soapservice.common.ErrorResponse;
import com.example.soapservice.common.SuccessResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ExpbolEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/soapservice/expbol";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EXP_BOL_Request")
    @ResponsePayload
    public EXPBOLResponse handleExpBolRequest(@RequestPayload EXPBOLRequest request) {
        EXPBOLResponse response = new EXPBOLResponse();
        SuccessResponse success = new SuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }
}
