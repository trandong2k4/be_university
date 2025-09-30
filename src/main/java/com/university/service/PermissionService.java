package com.university.service;

import com.university.entity.Permission;
import com.university.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    public Optional<Permission> findById(UUID id) {
        return permissionRepository.findById(id);
    }

    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    public void deleteById(UUID id) {
        permissionRepository.deleteById(id);
    }

    public boolean existsByMaPermission(String maPermission) {
        return permissionRepository.existsByMaPermission(maPermission);
    }
}
