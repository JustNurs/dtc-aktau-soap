package com.example.soapservice;

import com.example.soapservice.codeco.CODECOINRequest;
import com.example.soapservice.codeco.CODECOOUTRequest;
import com.example.soapservice.codeco.CODECOResponse;
import com.example.soapservice.coarri.COARRIINRequest;
import com.example.soapservice.coarri.COARRIOUTRequest;
import com.example.soapservice.coarri.COARRIResponse;
import com.example.soapservice.common.HeaderType;
import com.example.soapservice.expbol.EXPBOLRequest;
import com.example.soapservice.expbol.EXPBOLResponse;
import com.example.soapservice.vvnotice.VVNOTICERequest;
import com.example.soapservice.vvnotice.VVNOTICEResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SoapServiceApplicationTests {

    @LocalServerPort
    private int port;

    private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    private Jaxb2Marshaller marshaller(String contextPath) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(contextPath);
        return marshaller;
    }

    @Test
    void testCodecoIn() {
        webServiceTemplate.setMarshaller(marshaller("com.example.soapservice.codeco"));
        webServiceTemplate.setUnmarshaller(marshaller("com.example.soapservice.codeco"));
        com.example.soapservice.codeco.ObjectFactory factory = new com.example.soapservice.codeco.ObjectFactory();
        CODECOINRequest request = factory.createCODECOINRequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        CODECOResponse response = (CODECOResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }

    @Test
    void testCodecoOut() {
        webServiceTemplate.setMarshaller(marshaller("com.example.soapservice.codeco"));
        webServiceTemplate.setUnmarshaller(marshaller("com.example.soapservice.codeco"));
        com.example.soapservice.codeco.ObjectFactory factory = new com.example.soapservice.codeco.ObjectFactory();
        CODECOOUTRequest request = factory.createCODECOOUTRequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        CODECOResponse response = (CODECOResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }

    @Test
    void testCoarriIn() {
        webServiceTemplate.setMarshaller(marshaller("com.example.soapservice.coarri"));
        webServiceTemplate.setUnmarshaller(marshaller("com.example.soapservice.coarri"));
        com.example.soapservice.coarri.ObjectFactory factory = new com.example.soapservice.coarri.ObjectFactory();
        COARRIINRequest request = factory.createCOARRIINRequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        COARRIResponse response = (COARRIResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }

    @Test
    void testCoarriOut() {
        webServiceTemplate.setMarshaller(marshaller("com.example.soapservice.coarri"));
        webServiceTemplate.setUnmarshaller(marshaller("com.example.soapservice.coarri"));
        com.example.soapservice.coarri.ObjectFactory factory = new com.example.soapservice.coarri.ObjectFactory();
        COARRIOUTRequest request = factory.createCOARRIOUTRequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        COARRIResponse response = (COARRIResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }

    @Test
    void testVvNotice() {
        webServiceTemplate.setMarshaller(marshaller("com.example.soapservice.vvnotice"));
        webServiceTemplate.setUnmarshaller(marshaller("com.example.soapservice.vvnotice"));
        com.example.soapservice.vvnotice.ObjectFactory factory = new com.example.soapservice.vvnotice.ObjectFactory();
        VVNOTICERequest request = factory.createVVNOTICERequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        VVNOTICEResponse response = (VVNOTICEResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }

    @Test
    void testExpBol() {
        webServiceTemplate.setMarshaller(marshaller("com.example.soapservice.expbol"));
        webServiceTemplate.setUnmarshaller(marshaller("com.example.soapservice.expbol"));
        com.example.soapservice.expbol.ObjectFactory factory = new com.example.soapservice.expbol.ObjectFactory();
        EXPBOLRequest request = factory.createEXPBOLRequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        EXPBOLResponse response = (EXPBOLResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }
}
