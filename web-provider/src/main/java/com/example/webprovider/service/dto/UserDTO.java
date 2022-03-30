package com.example.webprovider.service.dto;

import com.example.webprovider.domain.model.Role;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserDTO {

    private Role role;

    private String email;

    private BigDecimal accountState;

    private boolean isBlocked;
}
