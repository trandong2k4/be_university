package com.university.service;

import com.university.dto.reponse.LoginResponseDTO;
import com.university.dto.reponse.RegisterReponse;
import com.university.dto.request.RegisterRequest;
import com.university.entity.User;
import com.university.repository.UserRepository;
import com.university.security.JwtService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;
    public final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public RegisterReponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()).toString());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());

        user = userRepository.save(user);

        return new RegisterReponse(user.getId(), user.getUsername(), user.getFirstName() + " " + user.getLastName(),
                user.getDateOfBirth());
    }

    @Transactional
    public LoginResponseDTO authenticate(String username, String rawPassword) {
        System.out.println("Đang xác thực: " + username);
        try {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new EntityNotFoundException("Tài khoản không tồn tại"));
            System.out.println("Raw: " + rawPassword);
            System.out.println("Encoded: " + user.getPassword());
            System.out.println("Match: " + passwordEncoder.matches(rawPassword, user.getPassword()));
            if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
                throw new IllegalArgumentException("Sai mật khẩu");
            }
            String maRole = user.getRole().getMaRole();// user chỉ có 1 role

            System.out.println("marole la: " + maRole);
            String token = "dummy-token";
            return new LoginResponseDTO(user.getUsername(), maRole, token, user.getId());

        } catch (Exception e) {
            e.printStackTrace(); // 👈 In ra lỗi thật sự
            throw e;
        }
    }
}