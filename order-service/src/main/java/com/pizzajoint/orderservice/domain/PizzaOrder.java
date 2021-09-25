package com.pizzajoint.orderservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author raychong
 */
@Entity
public class PizzaOrder {
    @Id
    public String id;

    @Column(nullable = false)
    public String pizzaName;

    @Column(nullable = false)
    public Integer quantity;

    @Column(nullable = false)
    public BigDecimal amount;

    @Column(nullable = false)
    public ZonedDateTime createdTime;
}
