package com.gridbetjavaa.gridbetjavaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity()
@EnableAspectJAutoProxy
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 //       http.addFilter(new JwtAuthorizationFilter());
//
        http.csrf().disable().cors().configurationSource(corsConfigurationSource());

        http.authorizeRequests()
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/bets/*").permitAll();
                //.and().addFilter(jwtAuthenticationFilter)
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http
//                .csrf(csrf ->
//                        csrf
//                                .disable())
//                .authorizeHttpRequests(authRequest ->
//                        authRequest
//                                .requestMatchers("/auth/**").permitAll()
//                                .anyRequest().authenticated()
//                )

                .build();


    }

    CorsConfigurationSource corsConfigurationSource() {
        final var configuration = new CorsConfiguration();
        //configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setExposedHeaders(Arrays.asList("*"));
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        final var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }


}