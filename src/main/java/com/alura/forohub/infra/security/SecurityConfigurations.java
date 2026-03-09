package com.alura.forohub.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable()) // Apagamos el escudo que bloquea los POST
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // Pedimos contraseña para todo
                )
                .httpBasic(Customizer.withDefaults()) // Usamos el login simple de Insomnia
                .build();
    }
}