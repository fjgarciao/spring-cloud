package com.in28minutes.microservices.currencyexchangeservice.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abstract_generator")
    @SequenceGenerator(name = "abstract_generator", sequenceName = "exchangevalue_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, name = "currency_from")
    private String from;

    @Column(nullable = false, name = "currency_to")
    private String to;

    @Column(nullable = false)
    private BigDecimal conversionMultiple;

    @JsonInclude
    @Transient
    private int port;

    protected ExchangeValue() {
    }

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
