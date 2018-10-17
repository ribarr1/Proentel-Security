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



}
