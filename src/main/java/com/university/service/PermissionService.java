package com.university.service;

import com.university.dto.reponse.PermissionResponse;
import com.university.dto.request.PermissionRequest;
import com.university.entity.Permission;
import com.university.mapper.PermissionMapper;
import com.university.repository.PermissionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public PermissionService(PermissionRepository permissionRepository, PermissionMapper permissionMapper) {
        this.permissionRepository = permissionRepository;
        this.permissionMapper = permissionMapper;
    }

    public PermissionResponse createPermission(PermissionRequest request) {
        Permission permission = permissionMapper.toEntity(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toResponse(permission);
    }

    public List<PermissionResponse> getAllPermissions() {
        return permissionRepository.findAll().stream()
                .map(permissionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PermissionResponse getPermissionById(UUID id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Permission not found"));
        return permissionMapper.toResponse(permission);
    }

    public PermissionResponse updatePermission(UUID id, PermissionRequest request) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Permission not found"));
        permissionMapper.updateEntity(permission, request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toResponse(permission);
    }

    public void deletePermission(UUID id) {
        if (!permissionRepository.existsById(id)) {
            throw new EntityNotFoundException("Permission not found");
        }
        permissionRepository.deleteById(id);
    }

    public List<PermissionResponse> searchByMaPermission(String keyword) {
        return permissionRepository.findByMaPermissionContainingIgnoreCase(keyword).stream()
                .map(permissionMapper::toResponse)
                .collect(Collectors.toList());
    }
}
