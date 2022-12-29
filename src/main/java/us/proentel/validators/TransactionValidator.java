/******************************************************************
 *  
 * This code is for the Income verification project.
 *
 * 
 * © 2018, EQB Management All rights reserved. 
 * 
 * 
 ******************************************************************/

package co.ppk.validators;

import co.ppk.dto.OperatorDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


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
		return OperatorDto.class.equals(clazz);
	}
}