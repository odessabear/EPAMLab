package com.example.webprovider.service.dto;

import com.example.webprovider.domain.model.OrderStatus;
import com.example.webprovider.domain.model.Tariff;
import com.example.webprovider.domain.model.User;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class OrderDTO {

    private Integer id;

    private User user;

    private List<Tariff> tariffList;

    private BigDecimal orderCost;

    private Timestamp createDate;

    private Timestamp updateDate;

    private OrderStatus orderStatus;
}
