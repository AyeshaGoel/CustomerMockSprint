package com.cg.customermgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.customermgt.customer.ui.*;

@SpringBootApplication
public class CustomermgtApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CustomermgtApplication.class, args);
		CustomerUI customerUI= context.getBean(CustomerUI.class);
		customerUI.start();
		
		//CustomerUI itemUI = context.getBean(CustomerUI.class);
	//	itemUI.start();
	}

}
