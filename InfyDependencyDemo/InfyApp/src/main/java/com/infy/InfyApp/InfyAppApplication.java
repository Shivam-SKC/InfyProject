package com.infy.InfyApp;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.infy.service.CustomerServiceImpl;
import com.infy.util.SpringConfiguration;

@SpringBootApplication
public class InfyAppApplication {

	public static void main(String[] args) {
//		SpringApplication.run(InfyAppApplication.class, args);
		CustomerServiceImpl service = null;
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		service = (CustomerServiceImpl) context.getBean("customerService");
		System.out.println(service.fetchCustomer());
		context.close();
	}
	
	}


