/******************************************************************
 *
 * This code is for the Pappking service project.
 *
 *
 * © 2018, Pappking Management All rights reserved.
 *
 *
 ******************************************************************/
package us.proentel.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import us.proentel.config.ApplicationConfig;

/***
 * Configuration class for Spring IOC
 * 
 * @Descripcion
 * @author jmunoz
 * 
 * @version 1.0
 */

@SpringBootApplication
@Import({ApplicationConfig.class})
public class SpringBootController  {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.setProperty("PROENTEL_HOME", "/proentel");
		SpringApplication.run(SpringBootController.class, args);
	}

}
