package com.university.service;

import com.university.dto.reponse.PermissionResponseDTO;
import com.university.dto.reponse.TruongResponseDTO;
import com.university.dto.request.PermissionRequestDTO;
import com.university.entity.Permission;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.PermissionMapper;
import com.university.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public PermissionResponseDTO create(PermissionRequestDTO dto) {
        Permission permission = permissionMapper.toEntity(dto);
        return permissionMapper.toResponseDTO(permissionRepository.save(permission));
    }

    public List<PermissionResponseDTO> getAll() {
        return permissionRepository.findAll().stream()
                .map(permissionMapper::toResponseDTO)
                .toList();
    }

    public PermissionResponseDTO getById(UUID id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy quyền"));
        return permissionMapper.toResponseDTO(permission);
    }

    public List<PermissionResponseDTO> search(String keyword) {
        return permissionRepository.searchByMaPermission(keyword).stream()
                .map(permissionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PermissionResponseDTO update(UUID id, PermissionRequestDTO dto) {
        Permission existing = permissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy quyền"));
        existing.setMaPermission(dto.getTenPermission());
        existing.setDescription(dto.getMoTa());
        return permissionMapper.toResponseDTO(permissionRepository.save(existing));
    }

    public void delete(UUID id) {
        permissionRepository.deleteById(id);
    }
}