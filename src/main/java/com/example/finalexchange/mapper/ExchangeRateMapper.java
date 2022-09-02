package com.example.finalexchange.mapper;

import com.example.finalexchange.controller.response.TransactionResponse;
import com.example.finalexchange.data.model.Transaction;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {
    TransactionResponse transactionToTransactionResponse(Transaction transaction);

    List<TransactionResponse> transactionToTransactionResponses(List<Transaction> transaction);

    @InheritInverseConfiguration
   Transaction dtoToModel(TransactionResponse transactionResponse);

}
