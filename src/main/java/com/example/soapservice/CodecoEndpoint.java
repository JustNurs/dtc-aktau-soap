package com.example.soapservice;

import com.example.soapservice.codeco.CODECOINRequest;
import com.example.soapservice.codeco.CODECOOUTRequest;
import com.example.soapservice.codeco.CODECOResponse;
import com.example.soapservice.common.ErrorResponse;
import com.example.soapservice.common.SuccessResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CodecoEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/soapservice/codeco";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CODECO_IN_Request")
    @ResponsePayload
    public CODECOResponse handleCodecoInRequest(@RequestPayload CODECOINRequest request) {
        CODECOResponse response = new CODECOResponse();
        SuccessResponse success = new SuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CODECO_OUT_Request")
    @ResponsePayload
    public CODECOResponse handleCodecoOutRequest(@RequestPayload CODECOOUTRequest request) {
        CODECOResponse response = new CODECOResponse();
        SuccessResponse success = new SuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }
}
