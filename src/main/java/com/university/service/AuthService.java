package com.university.service;

import com.university.dto.reponse.LoginResponseDTO;
import com.university.dto.reponse.RegisterReponse;
import com.university.dto.request.RegisterRequest;
import com.university.entity.User;
import com.university.repository.UserRepository;
import com.university.security.JwtService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public RegisterReponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setCreateDate(request.getDateOfBirth());

        user = userRepository.save(user);

        return new RegisterReponse(
                user.getId(),
                user.getUsername(),
                user.getFirstName() + " " + user.getLastName(),
                user.getCreateDate());
    }

    @Transactional
    public LoginResponseDTO authenticate(String username, String rawPassword) {
        System.out.println("Đang xác thực: " + username);

        // 1. Tìm user
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Tài khoản không tồn tại"));


        // 2. Tài khoản bị khóa → 401
        if (user.isStatus()) {
            throw new BadCredentialsException("Tài khoản đã bị khóa");
            
        }
        // Debug
        System.out.println("Raw: " + rawPassword);
        System.out.println("Encoded: " + user.getPassword());
        System.out.println("Match: " + passwordEncoder.matches(rawPassword, user.getPassword()));

        // 3. Sai mật khẩu → 401
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new BadCredentialsException("Sai mật khẩu");
        }

        // 4. Lấy role
        String maRole = user.getRole().getMaRole();

        System.out.println("marole la: " + maRole);

        // 5. Tạo token thật từ JwtService
        String token = "my-secret-key";
        // String token = jwtService.generateToken(user);

        // 5. Trả về
        return new LoginResponseDTO(
                user.getUsername(),
                maRole,
                token,
                user.getId());
    }
}
