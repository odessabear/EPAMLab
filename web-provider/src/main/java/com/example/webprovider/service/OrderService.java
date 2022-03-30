package com.example.webprovider.service;


import com.example.webprovider.service.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getOrdersByUserEmail(String email);

    OrderDTO makeOrder(OrderDTO orderDTO);

    void cancelOrder(Integer id);

    void payOrder(Integer id);
}
