package us.proentel.config.security;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import us.proentel.jwt.JwtEntryPoint;

import java.util.Arrays;

/***
 * Main security configuration files where resides the authorization rules and
 * general configuration features
 * 
 * @author ribarra
 *
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LogManager.getLogger(SecurityConfig.class);
	@Autowired
	JwtEntryPoint jwtEntryPoint;
	/**
	 * method with authentication rules and general configuration
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.applyPermitDefaultValues();
		corsConfig.setAllowCredentials(false);
		corsConfig.setAllowedMethods(Arrays.asList("HEAD",
				"GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
		corsConfig.setAllowedHeaders(Arrays.asList("*"));
		corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:8083", "http://3.217.201.31:8080","http://localhost:8002","*"));

		http.csrf().disable();
		http.authorizeRequests().mvcMatchers("v1/**").permitAll().and().cors().configurationSource(request -> corsConfig);




		/*http.cors().and().csrf().disable();
		http.authorizeRequests().mvcMatchers("http://3.217.201.31:8080/proentel.security.be.api/v1/**").permitAll().and().cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
		http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)).and().sessionManagement();
*/
	//	http.authorizeRequests().mvcMatchers("http://3.217.201.31:8080/proentel.security.be.api/v1/**").permitAll().and().csrf().disable();
//		http.authorizeRequests().mvcMatchers("/v1/**").permitAll().and().csrf().disable();

	/*	http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/v1/city/").permitAll()
				.anyRequest().authenticated();*/



		/*http.cors().and().csrf().disable()
				.authorizeRequests()
				.antMatchers("/api/v1/mm/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);*/




	//	http.headers().defaultsDisabled().cacheControl().and().httpStrictTransportSecurity().and().contentTypeOptions()
	//			.and().xssProtection().and().frameOptions();

	//	http.csrf().disable();
		
	//	http.authorizeRequests().mvcMatchers("/v1/message").permitAll().and().csrf().disable();
	//	http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)).and().sessionManagement();
		
		// http.authorizeRequests().mvcMatchers("/v1/login").anonymous().and().authorizeRequests()
		// .antMatchers("/", "/onboarding", "/mortgages", "/statements", "/messages",
		// "/profile", "/reset",
		// "/newDevice", "/scripts/**", "/styles/**", "/fonts/**", "/assets/**",
		// "/favicon.ico")
		// .permitAll().and().authorizeRequests()
		// .mvcMatchers("/api/config/translations", "/api/terms_and_conditions",
		// "/api/onboard", "/api/email",
		// "api/password", "/api/onboard/link/process", "/api/otp/**",
		// "api/transaction/credentials/reset",
		// "api/transaction/credentials/reset/cmd_proccess", "/api/languages")
		// .permitAll().and().authorizeRequests().mvcMatchers("/api/**").hasAuthority("USER").and()
		// .authorizeRequests().anyRequest().denyAll().and().logout().logoutUrl("api/logout")
		// .clearAuthentication(true).deleteCookies("JSESSIONID").invalidateHttpSession(true);

	}


	/**
	 * method used to activate debug security trace based on logger level
	 * 
	 * @param web
	 * @throws Exception
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		if (LOGGER.isDebugEnabled()) {
			web.debug(true);
		}
	}


	/*@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();

	}
	*/

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}



}
