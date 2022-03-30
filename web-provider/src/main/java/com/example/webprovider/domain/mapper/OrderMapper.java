package com.example.webprovider.domain.mapper;

import com.example.webprovider.domain.model.Order;
import com.example.webprovider.service.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO orderToOrderDTO(Order order);

    Order orderDTOToOrder(OrderDTO orderDTO);

    List<OrderDTO> ordersToOrdersDTO(List<Order> orders);
}
