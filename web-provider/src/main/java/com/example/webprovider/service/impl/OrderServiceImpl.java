package com.example.webprovider.service.impl;

import com.example.webprovider.domain.mapper.OrderMapper;
import com.example.webprovider.domain.model.Order;
import com.example.webprovider.domain.model.OrderStatus;
import com.example.webprovider.domain.repository.OrderRepository;
import com.example.webprovider.domain.repository.UserRepository;
import com.example.webprovider.service.OrderService;
import com.example.webprovider.service.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public List<OrderDTO> getOrdersByUserEmail(String email) {
        return orderRepository.orderList()
                .stream()
                .filter(order -> order.getUser()
                        .getEmail().equals(email))
                .map(OrderMapper.INSTANCE::orderToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO makeOrder(OrderDTO orderDTO) {
        orderDTO.setOrderStatus(OrderStatus.CREATED);
        Order order = OrderMapper.INSTANCE.orderDTOToOrder(orderDTO);
        order.setUser(userRepository.getUser(orderDTO.getUser().getEmail()));
        log.info("Order with id {} was created", orderDTO.getId());
        return OrderMapper.INSTANCE.orderToOrderDTO(order);
    }

    @Override
    public void cancelOrder(Integer id) {
        Order order = orderRepository.getOrder(id);
        order.setOrderStatus(OrderStatus.CANCELED);
        orderRepository.updateOrder(id, order);
        log.info("Order with id {} was canceled", id);
    }

    @Override
    public void payOrder(Integer id) {
        Order order = orderRepository.getOrder(id);
        order.setOrderStatus(OrderStatus.PAID);
        orderRepository.updateOrder(id, order);
        log.info("Order with id {} was paid", id);
    }
}
