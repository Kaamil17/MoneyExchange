package com.example.finalexchange.service;

import com.example.finalexchange.model.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;

@Service
@FeignClient(value = "url-service", url = "\"https://exchange-rates.abstractapi.com/v1/live/?api_key=c0b96d1c04464cef91c2304909193f55&base=")
public interface apiServiceInterface {

   // @RequestMapping(method = RequestMethod.GET, value = "/{baseCurrency}=&target=+{targetCurrency}")
  //  List<String> newExchanger(@PathVariable String baseCurrency, @PathVariable String targetCurrency);

    HashMap<String, String> exchanger(@PathVariable String baseCurrency, double sourceAmount, @PathVariable String targetCurrency);


}
