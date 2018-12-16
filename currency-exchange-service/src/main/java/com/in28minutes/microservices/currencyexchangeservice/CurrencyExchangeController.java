package com.in28minutes.microservices.currencyexchangeservice;

import com.in28minutes.microservices.currencyexchangeservice.bean.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    private Environment environment;
    private ExchangeValueRepository repository;

    @Autowired
    public CurrencyExchangeController(Environment environment, ExchangeValueRepository repository) {
        this.environment = environment;
        this.repository = repository;
    }

    @GetMapping("/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = repository.getByFromAndTo(from, to).orElseThrow(() -> new RuntimeException("ExchangeValue not found"));
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("{}", exchangeValue);
        return exchangeValue;
    }
}
