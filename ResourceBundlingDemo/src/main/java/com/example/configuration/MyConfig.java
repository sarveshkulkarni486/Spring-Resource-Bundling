package com.example.configuration;

import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MyConfig {
	@Bean
	public ResourceBundleMessageSource getObject() {
		System.out.println("in get object method");
		ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
		rs.setBasename("messages");
		return rs;
	}
}
