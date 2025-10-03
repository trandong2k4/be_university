package com.university.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.university.dto.reponse.RolePermissionResponse;
import com.university.entity.Permission;
import com.university.entity.Role;
import com.university.entity.RolePermission;
import com.university.mapper.RolePermissionMapper;
import com.university.repository.PermissionRepository;
import com.university.repository.RolePermissionRepository;
import com.university.repository.RoleRepository;

@Service
public class RolePermissionService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final RolePermissionRepository rolePermissionRepository;
    private final RolePermissionMapper rolePermissionMapper;

    public RolePermissionService(RoleRepository roleRepository, PermissionRepository permissionRepository,
            RolePermissionRepository rolePermissionRepository, RolePermissionMapper rolePermissionMapper) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.rolePermissionRepository = rolePermissionRepository;
        this.rolePermissionMapper = rolePermissionMapper;
    }

    public RolePermissionResponse assign(UUID roleId, UUID permissionId) {
        Role role = roleRepository.findById(roleId).orElseThrow();
        Permission permission = permissionRepository.findById(permissionId).orElseThrow();

        if (rolePermissionRepository.existsByRoleAndPermission(role, permission)) {
            throw new IllegalStateException("Vai trò đã có quyền này");
        }

        RolePermission rp = rolePermissionRepository.save(rolePermissionMapper.toEntity(role, permission));
        return rolePermissionMapper.toResponse(rp);
    }

    public List<RolePermissionResponse> getByRole(UUID roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow();
        return rolePermissionRepository.findByRole(role).stream()
                .map(rolePermissionMapper::toResponse)
                .collect(Collectors.toList());
    }
}
