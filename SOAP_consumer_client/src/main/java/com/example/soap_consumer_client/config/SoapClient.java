package com.example.soap_consumer_client.config;

import com.example.SOAP_consumer.Acknowledgement;
import com.example.SOAP_consumer.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {
    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public Acknowledgement getLoanStatus(CustomerRequest request) {
        template = new WebServiceTemplate(marshaller); //convert obj to xml? ok
        Acknowledgement acknowledgement = (Acknowledgement) template.marshalSendAndReceive("http://localhost:8080/ws", request);
        return acknowledgement;
    }
}
