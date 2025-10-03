package com.university.service;

import com.university.dto.reponse.UserResponse;
import com.university.dto.request.UserRequest;
import com.university.entity.Role;
import com.university.entity.User;
import com.university.entity.UserRole;
import com.university.mapper.UserMapper;
import com.university.repository.RoleRepository;
import com.university.repository.UserRepository;
import com.university.repository.UserRoleRepository;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,
            UserRoleRepository userRoleRepository, UserMapper userMapper,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toEntity(request, passwordEncoder);
        user = userRepository.save(user);
        return userMapper.toResponse(user);
    }

    public void assignRole(UUID userId, UUID roleId) {
        User user = userRepository.findById(userId).orElseThrow();
        Role role = roleRepository.findById(roleId).orElseThrow();

        if (!userRoleRepository.existsByUserAndRole(user, role)) {
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            userRoleRepository.save(userRole);
        }
    }
}