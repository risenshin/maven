package com.iddel.spt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 * 
 * -> @Configuration tags the class as a source of bean definitions for the application context.
   -> @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
   -> Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. 
      This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
   -> @ComponentScan tells Spring to look for other components, configurations, and services in the the hello package, allowing it to find the HelloController.
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@EnableAsync
@ComponentScan(basePackages = "com.iddel.spt")
@PropertySource("classpath:db.properties")
 public class IDDELApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
    	SpringApplication.run(IDDELApplication.class, args);
    }

    @Bean
	public PropertyPlaceholderConfigurer properties() {
		final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setIgnoreResourceNotFound(true);

		final List<Resource> resourceLst = new ArrayList<>();
		resourceLst.add(new ClassPathResource("query.properties"));
		resourceLst.add(new ClassPathResource("db.properties"));

		ppc.setLocations(resourceLst.toArray(new Resource[] {}));

		return ppc;
	}
}
