package com.qartzoo.microservices.order.service;

import com.qartzoo.microservices.order.dto.OrderRequest;
import com.qartzoo.microservices.order.model.Order;
import com.qartzoo.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;



@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository ;

    public void placeOrder(OrderRequest orderRequest){
        // map OrderRequest to order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        // save order
        orderRepository.save(order);


    }

}
