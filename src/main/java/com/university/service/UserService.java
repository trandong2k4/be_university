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

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,
            RoleRepository roleRepository,
            UserRoleRepository userRoleRepository,
            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.userMapper = userMapper;
    }

    // Lấy tất cả người dùng
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("Tổng số user: " + users.size()); // Debug
        return users.stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    // Lấy người dùng theo ID
    public UserResponse getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy người dùng"));
        return userMapper.toResponse(user);
    }

    // Tạo mới người dùng
    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword()); // nên mã hóa nếu dùng Spring Security
        user = userRepository.save(user);
        return userMapper.toResponse(user);
    }

    // Cập nhật người dùng
    public UserResponse updateUser(UUID id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy người dùng"));

        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());

        user = userRepository.save(user);
        return userMapper.toResponse(user);
    }

    // Xóa người dùng
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    // Gán vai trò cho người dùng
    public void assignRole(UUID userId, UUID roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy người dùng"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy vai trò"));

        if (userRoleRepository.existsByUserAndRole(user, role)) {
            throw new IllegalStateException("Người dùng đã có vai trò này");
        }

        UserRole ur = new UserRole();
        ur.setUser(user);
        ur.setRole(role);
        userRoleRepository.save(ur);
    }
}