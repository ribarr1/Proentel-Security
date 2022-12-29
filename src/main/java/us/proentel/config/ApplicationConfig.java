/******************************************************************
 *
 * This code is for the Pappking service project.
 *
 *
 * © 2018, Pappking Management All rights reserved.
 *
 *
 ******************************************************************/

package us.proentel.config;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import us.proentel.utilities.PropertyManagerApacheImpl;

/***
 * Configuration class for Spring IOC
 * 
 * @Descripcion
 * @author ribarra
 * 
 * @version 1.0
 */

@Configuration
@ComponentScan(basePackages = "us.proentel")
@EnableWebMvc
public class ApplicationConfig {

	private static final String PROENTEL_ENV_VAR = "PROENTEL_HOME";
	private static final String PROENTEL_MSTR_CONFG = "properties/master-config.properties";
	
	/** The log. */
	private final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

	private Properties properties;

	/**
	 * Gets the error properties. Create Beans to read error properties file. This
	 * properties file is valid throughout of application . Known as name of
	 * errorProperties
	 * 
	 * @return the error properties
	 */
	@Bean(name = "errorProperties")
	public Properties getErrorProperties() {
		properties = null;
		try {
			ClassPathResource resource = new ClassPathResource("/properties/errorCodes.properties");
			properties = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException exception) {
			log.error("Error in loading Error properties", exception);
		}
		return properties;
	}
	
	/***
	 * Inclusion of the Property management class in spring IOC
	 * 
	 * 
	 * @return The property management component implemented using as base
	 *         apache commons configuration
	 * 
	 */
	@Bean("pm")
	public PropertyManagerApacheImpl getPM() {
		return new PropertyManagerApacheImpl(PROENTEL_ENV_VAR, PROENTEL_MSTR_CONFG);
	}
	
}