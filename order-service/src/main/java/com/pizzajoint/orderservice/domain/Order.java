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
public class Order {
    @Id
    public String id;

    @Column(name = "pizza_name", nullable = false)
    public String pizzaName;

    @Column(name = "quantity", nullable = false)
    public Integer quantity;

    @Column(name = "amount", nullable = false)
    public BigDecimal amount;

    @Column(name = "create_time", nullable = false)
    public ZonedDateTime creationTime;
}
