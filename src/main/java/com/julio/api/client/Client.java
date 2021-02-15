package com.julio.api.client;


import com.julio.api.client.model.InputRequest;
import com.julio.api.client.model.OutputRequest;

import org.springframework.ws.InvalidXmlException;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;

import java.io.IOException;
import java.io.InputStream;

import static javax.xml.soap.SOAPConstants.SOAP_1_2_PROTOCOL;


public class Client extends WebServiceGatewaySupport {



    public OutputRequest inputRequest(InputRequest request) {

        WebServiceTemplate template = getWebServiceTemplate();

        MessageFactory msgFactory = null;
        try {
            msgFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        } catch (SOAPException e) {
            e.printStackTrace();
        }

        SaajSoapMessageFactory newSoapMessageFactory = new SaajSoapMessageFactory(msgFactory);
        template.setMessageFactory(newSoapMessageFactory);


            OutputRequest response = (OutputRequest) template
                    .marshalSendAndReceive("http://localhost:8080/ws", request);

//            SOAPException e

        return response;
    }
}
