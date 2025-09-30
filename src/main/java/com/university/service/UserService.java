package com.university.service;

import com.university.dto.UserDTO;
import com.university.entity.User;
import com.university.mapper.UserMapper;
import com.university.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAllDTO() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<UserDTO> findByIdDTO(UUID id) {
        return userRepository.findById(id).map(UserMapper::toDTO);
    }

    public Optional<UserDTO> findByUsernameDTO(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    // Lưu user và trả về DTO
    public UserDTO saveDTO(User user) {
        return UserMapper.toDTO(userRepository.save(user));
    }

    // Update user
    public Optional<UserDTO> updateUser(UUID id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setDateOfBirth(userDetails.getDateOfBirth());
            return UserMapper.toDTO(userRepository.save(user));
        });
    }

}
