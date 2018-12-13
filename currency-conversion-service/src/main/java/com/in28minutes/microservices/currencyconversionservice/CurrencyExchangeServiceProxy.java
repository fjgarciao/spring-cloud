package com.in28minutes.microservices.currencyconversionservice;

import com.in28minutes.microservices.currencyexchangeservice.bean.ExchangeValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "currency-exchange-service", url = "localhost:8000/currency-exchange")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/from/{from}/to/{to}")
    ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
