package com.university.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.university.entity.Role;
import com.university.entity.User;
import com.university.entity.UserRole;
import com.university.mapper.UserRoleMapper;
import com.university.repository.RoleRepository;
import com.university.repository.UserRepository;
import com.university.repository.UserRoleRepository;

@Service
public class UserRoleService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper userRoleMapper;

    public UserRoleService(UserRepository userRepository, RoleRepository roleRepository,
            UserRoleRepository userRoleRepository, UserRoleMapper userRoleMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.userRoleMapper = userRoleMapper;
    }

    public UserRoleResponse assign(UUID userId, UUID roleId) {
        User user = userRepository.findById(userId).orElseThrow();
        Role role = roleRepository.findById(roleId).orElseThrow();

        if (userRoleRepository.existsByUserAndRole(user, role)) {
            throw new IllegalStateException("Người dùng đã có vai trò này");
        }
        UserRole ur = userRoleRepository.save(userRoleMapper.toEntity(user, role));
        return null; // userRoleMapper.toResponse(ur);
    }

    public List<UserRoleResponse> getByUser(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return null; // userRoleRepository.findByUser(user).stream().map(userRoleMapper::toResponse).collect(Collectors.toList());
    }
}
