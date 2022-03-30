package com.example.webprovider.service.impl;

import com.example.webprovider.domain.mapper.UserMapper;
import com.example.webprovider.domain.model.User;
import com.example.webprovider.domain.repository.UserRepository;
import com.example.webprovider.service.UserService;
import com.example.webprovider.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUser(String email) {
        log.info(this.getClass().getSimpleName() + " getUser method");
        User user = userRepository.getUser(email);
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info(this.getClass().getSimpleName() + " getAllUsers method");
        return UserMapper.INSTANCE.UsersToUsersDTO(userRepository.getAllUsers());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.info(this.getClass().getSimpleName() + " createUser method");
        User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
        user = userRepository.creatUser(user);
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    @Override
    public UserDTO updateUser(String email, UserDTO userDTO) {
        log.info(this.getClass().getSimpleName() + " updateUser method");
        User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
        user = userRepository.updateUser(email, user);
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    @Override
    public void blockUser(String email) {
        User user = userRepository.getUser(email);
        user.setBlocked(true);
        userRepository.updateUser(email, user);
        log.info("User with email {} is blocked", email);
    }

    @Override
    public void unblockUser(String email) {
        User user = userRepository.getUser(email);
        user.setBlocked(false);
        userRepository.updateUser(email, user);
        log.info("User with email {} is blocked", email);
    }

    @Override
    public void deleteUser(String email) {
        log.info(this.getClass().getSimpleName() + " deleteUser method");
        userRepository.deleteUser(email);
    }
}
