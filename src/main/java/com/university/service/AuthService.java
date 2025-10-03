package com.university.service;

import com.university.config.SecurityConfig;
import com.university.dto.reponse.AuthResponse;
import com.university.dto.reponse.RegisterReponse;
import com.university.dto.request.AuthRequest;
import com.university.dto.request.RegisterRequest;
import com.university.entity.User;
import com.university.repository.UserRepository;
import com.university.security.JwtService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse authenticate(AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Tài khoản không tồn tại"));

        if (!passwordEncoder.matches(request.getPassword(), new String(user.getPassword()))) {
            throw new BadCredentialsException("Sai mật khẩu");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(token, user.getUsername(), "ROLE_USER");
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
}
