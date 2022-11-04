package com.example.a4_spring_boot_soap.endpoint;

import com.example.a4_spring_boot_soap.service.LoanEligibilityService;
import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {
    public static final String NAMESPACE = "http://www.javatechie.com/spring/soap/api/loanEligibility";

    @Autowired
    private LoanEligibilityService service;

    @PayloadRoot(namespace = "http://www.javatechie.com/spring/soap/api/loanEligibility", localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request){
        return service.checkLoanEligibility(request);
    }
}
