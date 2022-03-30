package com.example.webprovider.service;


import com.example.webprovider.service.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUser(String email);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(String email, UserDTO userDTO);

    void blockUser(String email);

    void unblockUser(String email);

    void deleteUser(String email);
}
