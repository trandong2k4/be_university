package com.university.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Key bí mật dùng để ký token (tốt nhất lưu trong application.properties /
    // environment)
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Thời gian sống của token (ms) - 10 giờ
    private final long expiration = 1000 * 60 * 60 * 10;

    /**
     * Tạo token JWT dựa trên username
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey)
                .compact();
    }

    /**
     * Lấy username từ token
     */
    public String extractUsername(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException e) {
            return null; // token không hợp lệ
        }
    }

    /**
     * Kiểm tra token còn hợp lệ không
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("Token expired");
        } catch (JwtException e) {
            System.out.println("Token invalid");
        }
        return false;
    }
}
