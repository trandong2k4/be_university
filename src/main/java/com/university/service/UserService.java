package com.university.service;

import com.university.dto.reponse.UserResponseDTO;
import com.university.dto.request.UserRequestDTO;
import com.university.entity.User;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.UserMapper;
import com.university.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDTO create(UserRequestDTO dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashed = encoder.encode(dto.getPassword());
        User user = userMapper.toEntity(dto);
        user.setCreateDate(java.time.LocalDate.now());
        user.setPassword(hashed);
        return userMapper.toResponseDTO(userRepository.save(user));
    }

    public List<UserResponseDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }

    public UserResponseDTO getById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user"));
        return userMapper.toResponseDTO(user);
    }

    public List<UserResponseDTO> search(String keyword) {
        return userRepository.searchByUsername(keyword).stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO update(UUID id, UserRequestDTO dto) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user"));
        existing.setUsername(dto.getUsername());
        existing.setPassword(dto.getPassword());
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setStatus(dto.isStatus());
        existing.setNote(dto.getNote());
        // existing.setUpdateDate(new Date(System.currentTimeMillis()).toLocalDate());
        existing.setUpdateDate(java.time.LocalDate.now());
        return userMapper.toResponseDTO(userRepository.save(existing));
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}