package co.ppk.service;

import co.ppk.dto.BillboardDto;
import co.ppk.dto.RateDto;
import co.ppk.dto.TemporalTransactionDto;
import co.ppk.dto.TransactionDto;

public interface BusinessManager {

    TransactionDto findTransactionByFacePlate(String facePlate);

    TemporalTransactionDto getInitTransactionByFacePlate(String facePlate);

    BillboardDto getBillboardByCode (String code);

    String setTemporalTransaction(TemporalTransactionDto transactionT);

    String setConfirmedInitTransactionByFacePlate(TransactionDto transaction);

    TransactionDto getConfirmedTransactionByFacePlate (String facePlate);

    TransactionDto getEndTransactionByFacePlate (String facePlate);

    String createBillboard(BillboardDto billboard);

    String createRate(RateDto rate);

    String putEndTransactionById(String id);

    void updateBillboard(BillboardDto billboard);

    void deleteBillboard(String billboardId);
}
