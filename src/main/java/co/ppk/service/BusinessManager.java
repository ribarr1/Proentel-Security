package co.ppk.service;

import co.ppk.dto.OperatorDto;
import co.ppk.dto.WorkCodeDto;

public interface BusinessManager {

    WorkCodeDto getWorkCodeByAuthorizationCode(String authorizationCode);
    String createWorkCode (WorkCodeDto workCode);
    String createOperator (OperatorDto operator);
    OperatorDto getOperatorById(String id);

}
