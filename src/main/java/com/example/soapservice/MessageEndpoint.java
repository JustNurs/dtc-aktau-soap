package com.example.soapservice;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;

@Endpoint
public class MessageEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/soapservice";

    @Autowired
    private SoapRequestRepository soapRequestRepository;

    private void saveRequest(String messageType, Object request) {
        SoapRequest soapRequest = new SoapRequest();
        soapRequest.setMessageType(messageType);
        soapRequest.setRequestBody(request.toString());
        soapRequestRepository.save(soapRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CODECO_IN_Request")
    @ResponsePayload
    public Response handleCodecoInRequest(@RequestPayload CODECOINRequest request) {
        saveRequest("CODECO_IN", request);
        ObjectFactory factory = new ObjectFactory();
        Response response = factory.createResponse();
        SuccessResponse success = factory.createSuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CODECO_OUT_Request")
    @ResponsePayload
    public Response handleCodecoOutRequest(@RequestPayload CODECOOUTRequest request) {
        saveRequest("CODECO_OUT", request);
        ObjectFactory factory = new ObjectFactory();
        Response response = factory.createResponse();
        SuccessResponse success = factory.createSuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "COARRI_IN_Request")
    @ResponsePayload
    public Response handleCoarriInRequest(@RequestPayload COARRIINRequest request) {
        saveRequest("COARRI_IN", request);
        ObjectFactory factory = new ObjectFactory();
        Response response = factory.createResponse();
        SuccessResponse success = factory.createSuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "COARRI_OUT_Request")
    @ResponsePayload
    public Response handleCoarriOutRequest(@RequestPayload COARRIOUTRequest request) {
        saveRequest("COARRI_OUT", request);
        ObjectFactory factory = new ObjectFactory();
        Response response = factory.createResponse();
        SuccessResponse success = factory.createSuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "VV_NOTICE_Request")
    @ResponsePayload
    public Response handleVvNoticeRequest(@RequestPayload VVNOTICERequest request) {
        saveRequest("VV_NOTICE", request);
        ObjectFactory factory = new ObjectFactory();
        Response response = factory.createResponse();
        SuccessResponse success = factory.createSuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EXP_BOL_Request")
    @ResponsePayload
    public Response handleExpBolRequest(@RequestPayload EXPBOLRequest request) {
        saveRequest("EXP_BOL", request);
        ObjectFactory factory = new ObjectFactory();
        Response response = factory.createResponse();
        SuccessResponse success = factory.createSuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }
}
