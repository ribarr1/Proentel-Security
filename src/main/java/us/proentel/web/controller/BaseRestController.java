/******************************************************************
 *
 * This code is for the Pappking service project.
 *
 *
 * © 2018, Pappking Management All rights reserved.
 *
 *
 ******************************************************************/
package co.ppk.web.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import co.ppk.exception.PpkFieldValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import co.ppk.enums.ResponseKeyName;

/**
 * @author jmunoz
 *
 */
public abstract class BaseRestController {

	  /**
	   * The error properties.
	   */
	  @Autowired
	  @Qualifier("errorProperties")
	  protected Properties errorProperties;

	  /**
	   * Creates the success response using the key as provided payloadName and value as the provided object
	   *
	   * @param payLoadName the payLoad name - will be used as a key in the map response object
	   * @param object      the object - will be used a value in the map response object
	   * @return the hash map - Success Response map object
	   */
	  // The payLoad name is passed as ResponseKeyName now instead of String (which was used earlier)
	  protected HashMap<ResponseKeyName, Object> createSuccessResponse(ResponseKeyName payLoadName, Object object) {

	      HashMap<ResponseKeyName, Object> responseMap = new LinkedHashMap<ResponseKeyName, Object>();
	      responseMap.put(payLoadName, object);
	      return responseMap;

	  }

	  /**
	   * This Method is to validate the object and returns list of errors.
	   *
	   * @param result
	   * @return Map - If it has errors, else return null
	   */
	  protected ResponseEntity<Object> apiValidator(BindingResult result) throws PpkFieldValidationException {
	    // Validating API request
	    if (result.hasErrors()) {
	      throw new PpkFieldValidationException(result);

	    } else {
	      return null;
	    }
	  }

	/**
	 * Create a login response when payment failed.
	 *
	 * @param payLoadName the payLoad name - will be used as a key in the map response object
	 * @param object the object - will be used a value in the map response object
	 * @param e the excepion - will be used to log the exception for debug use
	 * @return the hash map - Success Response map object
	 */

	protected HashMap<ResponseKeyName, Object> createFailResponse(ResponseKeyName payLoadName, Object object, Exception e) {
		HashMap<ResponseKeyName, Object> responseMap = new LinkedHashMap<ResponseKeyName, Object>();
		responseMap.put(payLoadName, object);
		return responseMap;
	}
}
