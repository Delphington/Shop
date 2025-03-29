package com.programming.delphington.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final String[] freeResourceUrls = {"/swagger-ui.html", "/swagger-ui/**",
            "/v3/api-docs/**", "/swagger-resources/**", "/api-docs/**",
            "/aggregate/**"};

    private final String[] freeResourceUrls2 = {"/swagger-ui.html", "/swagger-ui/**",
            "/v3/api-docs/**", "/swagger-resources/**", "/api-docs/**",
            "/aggregate/**", "/api/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // Разрешаем доступ ко всем маршрутам без аутентификации                        .anyRequest().authenticated()                   // Остальные маршруты требуют аутентификации
                )
                .csrf(csrf -> csrf.disable());                     // Отключаем CSRF для API

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(freeResourceUrls)
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated())
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
//                .build();
//    }
}