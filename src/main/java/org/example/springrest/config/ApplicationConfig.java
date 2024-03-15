package org.example.springrest.config;

import lombok.RequiredArgsConstructor;
import org.example.springrest.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository
                .findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

}
