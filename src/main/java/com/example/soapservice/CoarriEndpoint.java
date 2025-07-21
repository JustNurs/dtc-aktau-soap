package com.example.soapservice;

import com.example.soapservice.coarri.COARRIINRequest;
import com.example.soapservice.coarri.COARRIOUTRequest;
import com.example.soapservice.coarri.COARRIResponse;
import com.example.soapservice.common.ErrorResponse;
import com.example.soapservice.common.SuccessResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CoarriEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/soapservice/coarri";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "COARRI_IN_Request")
    @ResponsePayload
    public COARRIResponse handleCoarriInRequest(@RequestPayload COARRIINRequest request) {
        COARRIResponse response = new COARRIResponse();
        SuccessResponse success = new SuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "COARRI_OUT_Request")
    @ResponsePayload
    public COARRIResponse handleCoarriOutRequest(@RequestPayload COARRIOUTRequest request) {
        COARRIResponse response = new COARRIResponse();
        SuccessResponse success = new SuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }
}
