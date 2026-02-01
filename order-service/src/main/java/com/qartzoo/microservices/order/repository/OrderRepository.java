package com.qartzoo.microservices.order.repository;

import com.qartzoo.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
