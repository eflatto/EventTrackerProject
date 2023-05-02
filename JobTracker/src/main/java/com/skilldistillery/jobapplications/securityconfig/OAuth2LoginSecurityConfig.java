//package com.skilldistillery.jobapplications.securityconfig;
//package com.skilldistillery.jobapplications.securityconfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class OAuth2LoginSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//       return http
//            .authorizeRequests(authorize -> authorize
//            	.antMatchers(HttpMethod.GET, "/api/jobapplications").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin(Customizer.withDefaults())
//            .oauth2Login(Customizer.withDefaults())
//            .build();
//         
//    }
//}
