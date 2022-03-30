package com.example.webprovider.domain.repository;


import com.example.webprovider.domain.model.Order;

import java.util.List;

public interface OrderRepository {

    Order getOrder(Integer id);

    List<Order> orderList();

    Order createOrder(Order order);

    Order updateOrder(Integer id, Order order);
}
