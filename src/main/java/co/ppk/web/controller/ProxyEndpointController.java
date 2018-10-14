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

import co.ppk.dto.BillboardDto;
import co.ppk.dto.RateDto;
import co.ppk.dto.TemporalTransactionDto;
import co.ppk.dto.TransactionDto;
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
@RequestMapping("/v1")
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


    @RequestMapping(value = "/transaction/{face_plate}", method = RequestMethod.GET)
    public ResponseEntity<Object> getTransactionByFacePlate(@PathVariable("face_plate") String facePlate,
                                                            HttpServletRequest request) {
        ResponseEntity<Object> responseEntity;
        try {
            TransactionDto transaction = businessManager.findTransactionByFacePlate(facePlate);
            responseEntity = ResponseEntity.ok(transaction);
        } catch (HttpClientErrorException ex) {
            responseEntity = setErrorResponse(ex, request);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/transaction/init/{face_plate}", method = RequestMethod.GET)
    public ResponseEntity<Object> getInitTransactionByFacePlate(@PathVariable("face_plate") String facePlate,
                                                            HttpServletRequest request) {
        ResponseEntity<Object> responseEntity;
        try {
            TemporalTransactionDto transactionT = businessManager.getInitTransactionByFacePlate(facePlate);
            responseEntity = ResponseEntity.ok(transactionT);
        } catch (HttpClientErrorException ex) {

            responseEntity = setErrorResponse(ex, request);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/billboard/find/{code}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBillboardByCode(@PathVariable("code") String code,
                                                                HttpServletRequest request) {
        ResponseEntity<Object> responseEntity;
        try {
            BillboardDto billboard = businessManager.getBillboardByCode(code);
            responseEntity = ResponseEntity.ok(billboard);
        } catch (HttpClientErrorException ex) {
            responseEntity = setErrorResponse(ex, request);
        }
        return responseEntity;

    }


    @RequestMapping(value = "/temporal-transaction/create", method = RequestMethod.POST)
    public ResponseEntity<Object> setTemporalTransaction(@RequestBody TemporalTransactionDto temporalTransaction,
                                                 BindingResult result) {
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        String transactionId = businessManager.setTemporalTransaction(temporalTransaction);
        if(transactionId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.ok(transactionId);
    }

    @RequestMapping(value = "/transaction/create", method = RequestMethod.POST)
    public ResponseEntity<Object> setConfirmedInitTransactionByFacePlate(@RequestBody TransactionDto transaction,
                                                         BindingResult result) {
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        String transactionId = businessManager.setConfirmedInitTransactionByFacePlate(transaction);
        if(transactionId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.ok(transactionId);
    }

    @RequestMapping(value = "/transaction/confirmed/{face_plate}", method = RequestMethod.GET)
    public ResponseEntity<Object> getConfirmedTransactionByFacePlate(@PathVariable("face_plate") String facePlate,
                                                                HttpServletRequest request) {
        ResponseEntity<Object> responseEntity;
        try {
            TransactionDto transaction = businessManager.getConfirmedTransactionByFacePlate(facePlate);
            responseEntity = ResponseEntity.ok(transaction);
        } catch (HttpClientErrorException ex) {
            responseEntity = setErrorResponse(ex, request);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/transaction/end/{face_plate}", method = RequestMethod.GET)
    public ResponseEntity<Object> getEndTransactionByFacePlate(@PathVariable("face_plate") String facePlate,
                                                                        HttpServletRequest request) {
        ResponseEntity<Object> responseEntity;
        try {
            TransactionDto transaction = businessManager.getEndTransactionByFacePlate(facePlate);
            responseEntity = ResponseEntity.ok(transaction);
        } catch (HttpClientErrorException ex) {
            responseEntity = setErrorResponse(ex, request);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/billboard/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createBillboard(@RequestBody BillboardDto billboard,
                                                                         BindingResult result) {
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        String billboardId = businessManager.createBillboard(billboard);
        if(billboardId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.ok(billboardId);
    }

    @RequestMapping(value = "/rate/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createRate(@RequestBody RateDto rate,
                                                  BindingResult result) {
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        String rateId = businessManager.createRate(rate);
        if(rateId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.ok(rateId);
    }

    @RequestMapping(value = "/status/update", method = RequestMethod.POST)
    public ResponseEntity<Object> putEndTransactionById(@PathVariable("id") String id,
                                                  BindingResult result) {
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        String transactionId = businessManager.putEndTransactionById(id);
        if(transactionId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.ok(transactionId);
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
