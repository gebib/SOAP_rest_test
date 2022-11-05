package com.example.soap_consumer_client;

import com.example.SOAP_consumer.Acknowledgement;
import com.example.SOAP_consumer.CustomerRequest;
import com.example.soap_consumer_client.client.SoapClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //we make this a rest controller to call it from somewhere.
public class SoapConsumerClientApplication {
    private static final Logger logger = LogManager.getLogger(SoapConsumerClientApplication.class);
    //lets inject our SOAP client here.
    private final SoapClient client;

    public SoapConsumerClientApplication(SoapClient client) {
        this.client = client;
    }

    @PostMapping("/getLoanStatus") //client will consume this xml
    public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
        logger.error("\n///////////: controller:::Request: " + request + "\n");
        return client.getLoanStatus(request); //we are just capturing the soap here and sending it as a REST response to requester.
    }

    public static void main(String[] args) {
        SpringApplication.run(SoapConsumerClientApplication.class, args);
    }

}
