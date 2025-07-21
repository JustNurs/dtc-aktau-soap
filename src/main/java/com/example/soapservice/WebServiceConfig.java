package com.example.soapservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "codeco")
    public DefaultWsdl11Definition codecoWsdl11Definition(XsdSchema codecoSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CodecoPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.example.com/soapservice/codeco");
        wsdl11Definition.setSchema(codecoSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema codecoSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/codeco.xsd"));
    }

    @Bean(name = "coarri")
    public DefaultWsdl11Definition coarriWsdl11Definition(XsdSchema coarriSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CoarriPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.example.com/soapservice/coarri");
        wsdl11Definition.setSchema(coarriSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema coarriSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/coarri.xsd"));
    }

    @Bean(name = "vvnotice")
    public DefaultWsdl11Definition vvnoticeWsdl11Definition(XsdSchema vvnoticeSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("VvnoticePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.example.com/soapservice/vvnotice");
        wsdl11Definition.setSchema(vvnoticeSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema vvnoticeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/vvnotice.xsd"));
    }

    @Bean(name = "expbol")
    public DefaultWsdl11Definition expbolWsdl11Definition(XsdSchema expbolSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ExpbolPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.example.com/soapservice/expbol");
        wsdl11Definition.setSchema(expbolSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema expbolSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/expbol.xsd"));
    }
}
