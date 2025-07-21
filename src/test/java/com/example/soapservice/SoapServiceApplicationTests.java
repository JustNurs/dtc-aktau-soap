package com.example.soapservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SoapServiceApplicationTests {

    @LocalServerPort
    private int port;

    private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    @BeforeEach
    void setUp() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.soapservice");
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
    }

    @Test
    void testCodecoIn() {
        CODECOINRequest request = new CODECOINRequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        Response response = (Response) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }

    @Test
    void testCodecoOut() {
        CODECOOUTRequest request = new CODECOOUTRequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        Response response = (Response) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }

    @Test
    void testCoarriIn() {
        COARRIINRequest request = new COARRIINRequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        Response response = (Response) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }

    @Test
    void testCoarriOut() {
        COARRIOUTRequest request = new COARRIOUTRequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        Response response = (Response) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }

    @Test
    void testVvNotice() {
        VVNOTICERequest request = new VVNOTICERequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        Response response = (Response) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }

    @Test
    void testExpBol() {
        EXPBOLRequest request = new EXPBOLRequest();
        HeaderType header = new HeaderType();
        header.setMessageId("test-id");
        request.setHeader(header);

        Response response = (Response) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);
        assertThat(response.getSuccess()).isNotNull();
        assertThat(response.getSuccess().getMsgid()).isEqualTo("test-id");
    }
}
