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
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import us.proentel.data.UserRepository;
import us.proentel.domain.*;
import us.proentel.dto.*;
import us.proentel.service.BusinessManager;
import us.proentel.validators.TransactionValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import us.proentel.enums.ResponseKeyName;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;


/**
 * Only service exposition point of services to FE layer
 * 
 * @author ribarra
 *
 */

@RestController
@RequestMapping("/v1")
public class ProxyEndpointController extends BaseRestController {

    private static final Logger LOGGER = LogManager.getLogger(ProxyEndpointController.class);

    /**
     * The error properties.
     */
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
     * @author ribarra
     * @version 1.0
     * @since 28/10/1022
     */


    ////////////////////USUARIOSSSSSSSSSSSSSSS
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody UserDto user,
                                             BindingResult result) {
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        String userId = businessManager.createUser(user);
        if (userId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        String status = "Success";
        if (userId.equals("USUARIO INVALIDO"))
            status = "Error";
        HashMap<String, String> response = new HashMap<>();
        response.put("status", status);
        response.put("body", userId);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity<Object> loginUser(@RequestBody LoginDto login,
                                            BindingResult result) {
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        JwtDto loginUser = businessManager.loginUser(login);

        return ResponseEntity.ok(loginUser);
    }


    //ROLESSSSSSSSSSSSSSSSSSSSSSSS
    @RequestMapping(value = "/rol/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createRol(@RequestBody RolDto rol,
                                             BindingResult result) {
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        String rolId = businessManager.createRol(rol);
        if(rolId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        String status="Success";
        if(rolId.equals("ROL YA EXISTE"))
            status = "Error";
        HashMap<String,String> response = new HashMap<>();
        response.put("status", status);
        response.put("body", rolId);
        return ResponseEntity.ok(response);
    }



    //MENUuUUUUUU

    @RequestMapping(value = "/menu/{rol}", method = RequestMethod.GET)
    public List<MenuDto> getMenuByRol(@PathVariable("rol") String rol, HttpServletRequest request) {
        ResponseEntity<Object> responseEntity;
        List<MenuDto> menus=null;
        try{
            menus = businessManager.getMenuByRol(rol);

        } catch (HttpClientErrorException ex) {
            responseEntity = setErrorResponse(ex, request);
        }
        return menus;
    }


    @RequestMapping(value = "/menu/items/{rol}/{itemId}", method = RequestMethod.GET)
    public List<FunctionDto> getFunctionByEntityId(@PathVariable("rol") String rol, @PathVariable("itemId") String itemId, HttpServletRequest request) {
        ResponseEntity<Object> responseEntity;
        List<FunctionDto> functionDtos=null;
        try{
            functionDtos = businessManager.getFunctionByEntityId(itemId,rol);

        } catch (HttpClientErrorException ex) {
            responseEntity = setErrorResponse(ex, request);
        }
        return functionDtos;
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
