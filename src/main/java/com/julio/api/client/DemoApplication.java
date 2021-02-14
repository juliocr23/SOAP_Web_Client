package com.julio.api.client;

import com.julio.api.client.model.Exam;
import com.julio.api.client.model.InputRequest;
import com.julio.api.client.model.OutputRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	private Client client;

	@RequestMapping("/input")
	public OutputRequest inputRequest(){

		InputRequest input = new InputRequest();
		Exam exam = new Exam();
		exam.setTest1(80);
		exam.setTest3(85);
		exam.setTest2(90);

		input.setExam(exam);
		return client.inputRequest(input);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



}
