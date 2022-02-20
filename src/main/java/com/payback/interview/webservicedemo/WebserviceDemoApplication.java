package com.payback.interview.webservicedemo;

import com.payback.interview.webservicedemo.configuration.CouponWebserviceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@Import(CouponWebserviceConfiguration.class)
@SpringBootApplication
public class WebserviceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceDemoApplication.class, args);
	}

}
