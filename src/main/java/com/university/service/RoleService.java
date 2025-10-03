package com.university.service;

import com.university.dto.reponse.RoleResponse;
import com.university.dto.request.RoleRequest;
import com.university.entity.Role;
import com.university.mapper.RoleMapper;
import com.university.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public RoleResponse create(RoleRequest request) {
        Role role = roleMapper.toEntity(request);
        role = roleRepository.save(role);
        return roleMapper.toResponse(role);
    }

    public List<RoleResponse> getAll() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toResponse)
                .collect(Collectors.toList());
    }
}