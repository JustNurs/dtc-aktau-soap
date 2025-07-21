package com.example.soapservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.ws.client.core.WebServiceTemplate;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SoapServiceApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private SoapClient soapClient;

    @Test
    void contextLoads() {
    }

    @Test
    void testSendAndReceive() throws Exception {
        ObjectFactory factory = new ObjectFactory();
        Data request = factory.createData();
        MessageType message = factory.createMessageType();
        HeaderType header = factory.createHeaderType();
        header.setMessageId("test-id");
        header.setSender("test-sender");
        header.setRecipient("test-recipient");
        header.setMessageType("INV");
        message.setHeader(header);

        PayloadType payload = factory.createPayloadType();
        INVType inv = factory.createINVType();
        inv.setWagonNumber("12345");
        inv.setInvoiceNumber("INV-123");
        inv.setWagonType("Covered");
        inv.setPreviousStationCode("ST1");
        inv.setSenderCargo("Sender");
        inv.setReceiverCargo("Receiver");
        GregorianCalendar gcal = new GregorianCalendar();
        XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        inv.setEtd(xgcal);
        inv.setForwarderBin("1234567890");
        CNTType cnt = factory.createCNTType();
        ContainersType containers = factory.createContainersType();
        ContainerType container = factory.createContainerType();
        container.setContainerNumber("C-123");
        container.setContSyncid("S-123");
        container.setTareWeight(100.0f);
        container.setIso("ISO-123");
        container.setEmpty(false);
        containers.getContainer().add(container);
        cnt.setContainers(containers);
        inv.setCNT(cnt);
        payload.setINV(inv);
        message.setPayload(payload);
        request.setMessage(message);

        GetResponse response = soapClient.sendInv("http://localhost:" + port + "/ws/messages", request);

        assertThat(response).isNotNull();
        assertThat(response.getData().getMessage().getMessageType()).isEqualTo("DONE");
    }
}
