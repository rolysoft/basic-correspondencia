package com.correspondencia;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sun.faces.config.ConfigureListener;

@SpringBootApplication
public class CorrespondenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrespondenciaApplication.class, args);
	}

	
	/*
	 * Below sets up the Faces Servlet for Spring Boot
	 */
	/*@Bean
	public FacesServlet facesServlet() {
	    return new FacesServlet();
	}*/
	
	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
		registration.setLoadOnStartup(1);
		registration.addUrlMappings("*.jr");
		return registration;
	}
	
	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return ServletContext -> {
			ServletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
			ServletContext.setInitParameter("com.sun.faces.expressionFactory", "org.apache.el.ExpressionFactoryImpl");
			//ServletContext.setInitParameter("org.omnifaces.FACES_VIEWS_SCAN_PATHS", "/*.xhtml/*");
			//ServletContext.setInitParameter("primefaces.THEME", "sunny");
		};
	}
	
	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<>(new ConfigureListener());
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
