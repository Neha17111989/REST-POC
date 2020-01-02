package com.altimetrik;



import java.util.Locale;

//import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class RestServiceApplication {

	
	@Bean 
	public LocaleResolver resolver() {
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	
	}
	
	/*
	 * @Bean public ResourceBundleMessageSource bundleMsg() {
	 * ResourceBundleMessageSource obj=new ResourceBundleMessageSource();
	 * obj.setBasename("messages"); return obj; }
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	
}
