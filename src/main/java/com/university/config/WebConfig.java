package com.university.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Áp dụng cho tất cả các đường dẫn API
            .allowedOrigins(
                "https://university-two-gamma.vercel.app", // Cho phép domain Vercel của bạn
                "http://localhost:3000",  // (Tùy chọn) Cho phép cả domain FE local để test
                "http://localhost:5173"   // (Tùy chọn) Hoặc port 5173 nếu dùng Vite
            )
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Các phương thức cho phép
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}