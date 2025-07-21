package com.example.soapservice;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapClient extends WebServiceGatewaySupport {

    public GetResponse sendInv(String uri, Data request) {
        return (GetResponse) getWebServiceTemplate().marshalSendAndReceive(uri, request);
    }
}
