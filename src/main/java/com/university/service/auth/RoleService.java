package com.university.service.auth;

import com.university.dto.reponse.RoleResponseDTO;
import com.university.dto.request.RoleRequestDTO;
import com.university.entity.Role;
import com.university.exception.ResourceNotFoundException;
import com.university.mapper.RoleMapper;
import com.university.repository.RoleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleResponseDTO create(RoleRequestDTO dto) {
        Role role = roleMapper.toEntity(dto);
        return roleMapper.toResponseDTO(roleRepository.save(role));
    }

    public List<RoleResponseDTO> getAll() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toResponseDTO)
                .toList();
    }

    public RoleResponseDTO getById(UUID id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy role"));
        return roleMapper.toResponseDTO(role);
    }

    public List<RoleResponseDTO> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return roleRepository.findAll()
                    .stream()
                    .map(roleMapper::toResponseDTO)
                    .toList();
        }
        return roleRepository.searchByMaRole(keyword.trim())
                .stream()
                .map(roleMapper::toResponseDTO)
                .toList();
    }

    public RoleResponseDTO update(UUID id, RoleRequestDTO dto) {
        Role existing = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy role"));
        existing.setMaRole(dto.getTenRole());
        existing.setDescription(dto.getMoTa());
        return roleMapper.toResponseDTO(roleRepository.save(existing));
    }

    public void delete(UUID id) {
        roleRepository.deleteById(id);
    }
}