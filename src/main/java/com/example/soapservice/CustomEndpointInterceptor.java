package com.example.soapservice;

import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class CustomEndpointInterceptor implements EndpointInterceptor {

    private static final ThreadLocal<String> requestThreadLocal = new ThreadLocal<>();

    public static String getRequest() {
        return requestThreadLocal.get();
    }

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            messageContext.getRequest().writeTo(buffer);
            String payload = buffer.toString(java.nio.charset.StandardCharsets.UTF_8.name());
            requestThreadLocal.set(payload);
        } catch (IOException e) {
            // handle exception
        }
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        requestThreadLocal.remove();
    }
}
