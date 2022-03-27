package com.example.webprovider.domain.mapper;


import com.example.webprovider.domain.model.User;
import com.example.webprovider.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    List<UserDTO> UsersToUsersDTO(List<User> users);
}
