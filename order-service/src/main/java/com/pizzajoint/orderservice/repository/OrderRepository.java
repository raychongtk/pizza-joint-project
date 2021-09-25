package com.pizzajoint.orderservice.repository;

import com.pizzajoint.orderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author raychong
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
