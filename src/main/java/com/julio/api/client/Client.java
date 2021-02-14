package com.julio.api.client;

import com.julio.api.client.model.Exam;
import com.julio.api.client.model.InputRequest;
import com.julio.api.client.model.OutputRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class Client extends WebServiceGatewaySupport {



    public OutputRequest inputRequest(InputRequest request) {

        OutputRequest outputRequest = new OutputRequest();
        Exam exam = request.getExam();

        double total = exam.getTest1() + exam.getTest2() + exam.getTest3();

        outputRequest.setGrade(total/3);

        return outputRequest;
    }
}
