package co.ppk.service.impl;

import co.ppk.data.BillboardRepository;
import co.ppk.data.RateRepository;
import co.ppk.data.TemporalTransactionRepository;
import co.ppk.domain.Billboard;
import co.ppk.domain.Transaction;
import co.ppk.domain.TemporalTransaction;
import co.ppk.dto.BillboardDto;
import co.ppk.dto.RateDto;
import co.ppk.dto.TemporalTransactionDto;
import co.ppk.dto.TransactionDto;
import co.ppk.service.BusinessManager;
import co.ppk.data.TransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

import static co.ppk.utilities.Constants.TRANSACTION_ALREADY_EXISTS;

@Component
public class BussinessManagerImpl implements BusinessManager{

    private static TransactionRepository transactionRepository;
    private static TemporalTransactionRepository temporalTransactionRepository;
    private static BillboardRepository billboardRepository;
    private static RateRepository rateRepository;

    private final static Logger LOGGER = LogManager.getLogger(BussinessManagerImpl.class);



    public BussinessManagerImpl() {
        temporalTransactionRepository = new TemporalTransactionRepository();
        transactionRepository = new TransactionRepository();
        billboardRepository = new BillboardRepository();
        rateRepository = new RateRepository();
    }

    @Override
    public TransactionDto findTransactionByFacePlate(String facePlate) {
        Optional<Transaction> transaction = transactionRepository.getTransactionByFacePlate(facePlate);
        if (!transaction.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        TransactionDto response = new TransactionDto();
        response.setPhone(transaction.get().getPhone());
        response.setBillboards_code(transaction.get().getBillboards_code());
        response.setLicense_plate(transaction.get().getLicense_plate());
        return response;
    }

    @Override
    public TemporalTransactionDto getInitTransactionByFacePlate(String facePlate) {
        Optional<TemporalTransaction> temporalTransaction = temporalTransactionRepository.getInitTransactionByFacePlate(facePlate);
        TemporalTransactionDto response = new TemporalTransactionDto();
        if (!temporalTransaction.isPresent()) {
            return response;
        }else{

            response.setId(temporalTransaction.get().getId());
            response.setPhone(temporalTransaction.get().getPhone());
            response.setBillboards_code(temporalTransaction.get().getBillboards_code());
            response.setLicense_plate(temporalTransaction.get().getLicense_plate());
            return response;
        }
    }


    @Override
    public BillboardDto getBillboardByCode(String code) {
        Optional<Billboard> billboard = billboardRepository.getBillboardByCode(code);
        BillboardDto response = new BillboardDto();
        if (!billboard.isPresent()) {
            return response;
        }
        response.setId(billboard.get().getId());
        response.setCode(billboard.get().getCode());
        response.setAddress(billboard.get().getAddress());

        return response;
    }

    @Override
    public String setTemporalTransaction(TemporalTransactionDto temporalTransaction) {
        if(temporalTransactionRepository.getInitTransactionByFacePlate(temporalTransaction.getLicense_plate()).isPresent()) {
            return TRANSACTION_ALREADY_EXISTS;
        }
        return temporalTransactionRepository.setTemporalTransaction(temporalTransaction);
    }

    @Override
    public String setConfirmedInitTransactionByFacePlate(TransactionDto transaction) {
        if(!transactionRepository.getConfirmedTransactionByFacePlate(transaction.getLicense_plate()).isPresent()) {
            return "No Existe";
        }
        return transactionRepository.setConfirmedInitTransactionByFacePlate(transaction);
    }

    @Override
    public TransactionDto getConfirmedTransactionByFacePlate(String facePlate) {
        Optional<Transaction> transaction = transactionRepository.getConfirmedTransactionByFacePlate(facePlate);
        if (!transaction.isPresent()) {throw new HttpClientErrorException(HttpStatus.NOT_FOUND); }
        //TODO: Replace this code for mapper approach
        TransactionDto response = new TransactionDto();
        response.setId(transaction.get().getId());
        response.setPhone(transaction.get().getPhone());
        response.setLicense_plate(transaction.get().getLicense_plate());
        response.setBillboards_code(transaction.get().getBillboards_code());
        response.setStart_date(transaction.get().getStart_date());
        response.setStart_time(transaction.get().getStart_time());
        response.setEnd_date(transaction.get().getEnd_date());
        response.setEnd_time(transaction.get().getEnd_time());
        response.setTime(transaction.get().getTime());
        response.setTime(transaction.get().getTime());
        response.setPrice(transaction.get().getPrice());
        response.setClosed(transaction.get().getClosed());
        return response;
    }

    @Override
    public TransactionDto getEndTransactionByFacePlate(String facePlate) {
        Optional<Transaction> transaction = transactionRepository.getConfirmedTransactionByFacePlate(facePlate);
        if (!transaction.isPresent()) {throw new HttpClientErrorException(HttpStatus.NOT_FOUND); }
        //TODO: Replace this code for mapper approach
        TransactionDto response = new TransactionDto();
        response.setId(transaction.get().getId());
        response.setPhone(transaction.get().getPhone());
        response.setLicense_plate(transaction.get().getLicense_plate());
        response.setBillboards_code(transaction.get().getBillboards_code());
        response.setStart_date(transaction.get().getStart_date());
        response.setStart_time(transaction.get().getStart_time());
        response.setEnd_date(transaction.get().getEnd_date());
        response.setEnd_time(transaction.get().getEnd_time());
        response.setTime(transaction.get().getTime());
        response.setTime(transaction.get().getTime());
        response.setPrice(transaction.get().getPrice());
        response.setClosed(transaction.get().getClosed());
        return response;
    }

    @Override
    public String createBillboard(BillboardDto billboard) {
        if(billboardRepository.getBillboardByCode(billboard.getCode()).isPresent()) {
            return "Ya Existe";
        }
        return billboardRepository.createBillboard(billboard);
    }

    @Override
    public String createRate(RateDto rate) {
        if(rateRepository.getRate(rate.getStatus()).isPresent()) {
            return "Ya Existe";
        }
        return rateRepository.createRate(rate);
    }

    @Override
    public String putEndTransactionById(String id) {
        return transactionRepository.putEndTransactionById(id);
    }

}
