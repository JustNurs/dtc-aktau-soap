package com.example.soapservice;

import com.example.soapservice.vvnotice.VVNOTICERequest;
import com.example.soapservice.vvnotice.VVNOTICEResponse;
import com.example.soapservice.common.ErrorResponse;
import com.example.soapservice.common.SuccessResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class VvnoticeEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/soapservice/vvnotice";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "VV_NOTICE_Request")
    @ResponsePayload
    public VVNOTICEResponse handleVvNoticeRequest(@RequestPayload VVNOTICERequest request) {
        VVNOTICEResponse response = new VVNOTICEResponse();
        SuccessResponse success = new SuccessResponse();
        success.setSender("POA");
        success.setRecipient("DTC");
        success.setMessageType("DONE");
        success.setMsgid(request.getHeader().getMessageId());
        response.setSuccess(success);
        return response;
    }
}
