/******************************************************************
 *  
 * This code is for the Income verification project.
 *
 * 
 * © 2018, EQB Management All rights reserved. 
 * 
 * 
 ******************************************************************/

package us.proentel.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import us.proentel.dto.UserDto;


@Component
public class TransactionValidator extends BaseValidator implements Validator {

	/*
	 * This method validates the login data
	 * 
	 * @return void no value is returning.
	 */
	@Override
	public void validate(Object target, Errors errors) {


	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.equals(clazz);
	}
}