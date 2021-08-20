package com.shannon.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineApplication {

	public static void main(String[] args) {
		OrderFactoryProducer producer = new OrderFactoryProducer();
		AbstractOrderFactory factory = producer.getOrderFactory("prime");
		SpringApplication.run(OnlineApplication.class, args);
	}

}
