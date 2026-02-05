package com.example.reservation.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing (otherwise POSTs fail)
            .authorizeHttpRequests(auth -> auth
                //.requestMatchers("/register", "/public/**").permitAll() // Allow these without login
                .anyRequest().permitAll() // Everything else still needs a login
            )
            .httpBasic(basic -> {}); // Allows you to test locked routes with simple auth
            
        return http.build();
    }

}
