package com.in28minutes.microservices.currencyexchangeservice;

import com.in28minutes.microservices.currencyexchangeservice.bean.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    Optional<ExchangeValue> getByFromAndTo(String from, String to);
}
