package co.ppk.service.impl;

import co.ppk.data.OperatorRepository;
import co.ppk.data.WorkCodeRepository;
import co.ppk.domain.Operator;
import co.ppk.domain.WorkCode;
import co.ppk.dto.OperatorDto;
import co.ppk.dto.WorkCodeDto;
import co.ppk.service.BusinessManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;
import java.util.Optional;

import static co.ppk.utilities.Constants.OPERATOR_CODE_ALREADY_EXISTS;
import static co.ppk.utilities.Constants.WORK_CODE_ALREADY_EXISTS;

@Component
public class BussinessManagerImpl implements BusinessManager{

    private static OperatorRepository operatorRepository;
    private static WorkCodeRepository workCodeRepository;

    private final static Logger LOGGER = LogManager.getLogger(BussinessManagerImpl.class);



    public BussinessManagerImpl() {

        operatorRepository = new OperatorRepository();
        workCodeRepository = new WorkCodeRepository();
    }

    @Override
    public WorkCodeDto getWorkCodeByAuthorizationCode(String authorizationCode) {
        Optional<WorkCode> workCode = workCodeRepository.getWorkCodeByAuthorizationCode(authorizationCode);
        WorkCodeDto response = new WorkCodeDto();
        if (!workCode.isPresent()) {
            return response;
        }
        response.setId(workCode.get().getId());
        response.setOperatorId(workCode.get().getOperatorId());
        response.setBillaboardId(workCode.get().getBillaboardId());
        response.setAuthorization_codes(workCode.get().getAuthorization_code());
        response.setStatus(workCode.get().getStatus());
        return response;
    }

     @Override
    public String createWorkCode(WorkCodeDto workCode) {
        if(workCodeRepository.getWorkCodeByAuthorizationCode(workCode.getAuthorization_code()).isPresent()) {
            return WORK_CODE_ALREADY_EXISTS;
        }
        return workCodeRepository.createWorkCode(workCode);
    }

    @Override
    public String createOperator(OperatorDto operator) {
        if(operatorRepository.getOperatorByDocument(operator.getDocument_type(),operator.getDocument_number()).isPresent()) {
            return OPERATOR_CODE_ALREADY_EXISTS;
        }
        return operatorRepository.createOperator(operator);
    }

    @Override
    public OperatorDto getOperatorById(String id) {
        Optional<Operator> operator = operatorRepository.getOperatorById(id);
        OperatorDto response = new OperatorDto();
        if (!operator.isPresent()) {
            return response;
        }
        response.setId(operator.get().getId());
        response.setDocument_type(operator.get().getDocument_type());
        response.setDocument_number(operator.get().getDocument_number());
        response.setName(operator.get().getName());
        response.setLast_name(operator.get().getLast_name());
        response.setAddress(operator.get().getAddress());
        response.setPersonal_phone(operator.get().getPersonal_phone());
        response.setAssigned_phones(operator.get().getAssigned_phone());
        response.setStatus(operator.get().getStatus());
        return response;
    }




}
