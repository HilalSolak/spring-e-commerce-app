package com.hilalsolak.ecommercespring;

import com.hilalsolak.ecommercespring.utils.LoggingAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class ECommerceSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(ECommerceSpringApplication.class, args);
	}

	@Bean
	public LoggingAspect aspect() {
		return new LoggingAspect();
	}
}
