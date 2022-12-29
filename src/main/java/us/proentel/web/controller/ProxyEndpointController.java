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
import java.util.Properties;

import co.ppk.dto.OperatorDto;
import co.ppk.dto.WorkCodeDto;
import co.ppk.service.BusinessManager;
import co.ppk.validators.TransactionValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import co.ppk.enums.ResponseKeyName;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;

/**
 * Only service exposition point of services to FE layer
 * 
 * @author jmunoz
 *
 */

@RestController
@RequestMapping("/v1/operators")
public class ProxyEndpointController extends BaseRestController {

	private static final Logger LOGGER = LogManager.getLogger(ProxyEndpointController.class);

	/** The error properties. */
	@Autowired
	@Qualifier("errorProperties")
	private Properties errorProperties;

	@Autowired
	BusinessManager businessManager;

	@Autowired
    TransactionValidator transactionValidator;

	/**
	 * entry endpoint receiving the message from messaging API to perform proper action
	 *
	 * @since 30/06/2018
	 *
	 * @author jmunoz
	 * @version 1.0
	 */


    @RequestMapping(value = "/work-codes/{authorizationCode}", method = RequestMethod.GET)
    public ResponseEntity<Object> getWorkCodeByAuthorizationCode(@PathVariable("authorizationCode") String authorizationCode,
                                                            HttpServletRequest request) {
        ResponseEntity<Object> responseEntity;
        try {
            WorkCodeDto workCode = businessManager.getWorkCodeByAuthorizationCode(authorizationCode);
            responseEntity = ResponseEntity.ok(workCode);
        } catch (HttpClientErrorException ex) {
            responseEntity = setErrorResponse(ex, request);
        }
        return responseEntity;
    }




    @RequestMapping(value = "/work-codes/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createWorkCode(@RequestBody WorkCodeDto workCode,
                                                         BindingResult result) {
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        String workCodeId = businessManager.createWorkCode(workCode);
        if(workCodeId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.ok(workCodeId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getOperatorById(@PathVariable("id") String id,
                                                                 HttpServletRequest request) {
        ResponseEntity<Object> responseEntity;
        try {
            OperatorDto operator = businessManager.getOperatorById(id);
            responseEntity = ResponseEntity.ok(operator);
        } catch (HttpClientErrorException ex) {
            responseEntity = setErrorResponse(ex, request);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createOperator(@RequestBody OperatorDto operator,
                                                 BindingResult result) {
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        String operatorId = businessManager.createOperator(operator);
        if(operatorId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.ok(operatorId);
    }



    private ResponseEntity<Object> setErrorResponse(HttpClientErrorException ex, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        HttpStatus status;
        switch (ex.getStatusCode().value()) {
            case 404:
                map.put("message", "Not Found");
                status = HttpStatus.NOT_FOUND;
                break;
            case 401:
                map.put("message", "Access denied");
                status = HttpStatus.UNAUTHORIZED;
                break;
            case 400:
                map.put("message", "bad request");
                status = HttpStatus.BAD_REQUEST;
                break;
            case 406:
                map.put("message", "invalid parameter");
                map.put("detail", ex.getMessage());
                status = HttpStatus.NOT_ACCEPTABLE;
                break;
            case 412:
                map.put("message", "invalid parameter");
                map.put("detail", ex.getMessage());
                status = HttpStatus.PRECONDITION_FAILED;
                break;
            case 500:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
            case 503:
                status = HttpStatus.SERVICE_UNAVAILABLE;
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                map.put("message", "There was a problem trying to resolve the request");
        }
        return ResponseEntity.status(status)
                .body(createFailResponse(ResponseKeyName.TRANSACTION_RESPONSE, map, ex));

    }
}
