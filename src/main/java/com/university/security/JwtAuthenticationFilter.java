// package com.university.security;

// import com.university.service.UserDetailsServiceImpl;
// import com.university.util.JwtUtil;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import java.io.IOException;

// @Component
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

// @Autowired
// private JwtUtil jwtUtil;

// @Autowired
// private UserDetailsServiceImpl userDetailsService;

// @Override
// protected void doFilterInternal(HttpServletRequest request,
// HttpServletResponse response,
// FilterChain filterChain)
// throws ServletException, IOException {

// String path = request.getServletPath();
// if (path.startsWith("/api/auth/")) {
// // Bỏ qua filter cho login, register, forgetpassword
// filterChain.doFilter(request, response);
// return;
// }

// String authHeader = request.getHeader("Authorization");

// if (authHeader != null && authHeader.startsWith("Bearer ")) {
// String token = authHeader.substring(7);
// String username = jwtUtil.extractUsername(token);

// if (username != null &&
// SecurityContextHolder.getContext().getAuthentication() == null) {
// UserDetails userDetails = userDetailsService.loadUserByUsername(username);

// if (jwtUtil.validateToken(token)) {
// UsernamePasswordAuthenticationToken authToken = new
// UsernamePasswordAuthenticationToken(
// userDetails, null, userDetails.getAuthorities());
// SecurityContextHolder.getContext().setAuthentication(authToken);
// }
// }
// }

// filterChain.doFilter(request, response);
// }
// }
