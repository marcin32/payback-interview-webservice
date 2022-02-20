package com.payback.interview.webservicedemo;

import com.payback.interview.webservicedemo.respository.CouponRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = CouponRepository.class)
public class TestJpaConfiguration {

}
