package com.skilldistillery.jobapplications.securityconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // this you get for free when you configure the db connection in application.properties file
    @Autowired
    private DataSource dataSource;

    // this bean is created in the application starter class if you're looking for it
    @Autowired
    private PasswordEncoder encoder;
	
    @Bean
    public SecurityFilterChain createFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf().disable()//disable Cross-Site Request Forgery
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll() // For CORS, the preflight request
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()     // will hit the OPTIONS on the route
        .antMatchers(HttpMethod.GET, "/api/jobapplications").hasRole("admin")     // will hit the OPTIONS on the route
        .antMatchers(HttpMethod.GET, "/api/jobapplications").hasRole("ADMIN")     // will hit the OPTIONS on the route
        .antMatchers(HttpMethod.GET, "/api/jobapplications").hasRole("Admin")     // will hit the OPTIONS on the route
        .antMatchers("/api/**").authenticated() // Requests for our REST API must be authorized.
        .antMatchers("/api/users/admin/**").hasRole("ADMIN") // Requests for our REST API must be authorized.
        .anyRequest().permitAll()               // All other requests are allowed without authentication.
        .and()
        .httpBasic();                           // Use HTTP Basic Authentication

        http
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        return http.build();
    }
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Check if username/password are valid, and user currently allowed to authenticate
        String userQuery = "SELECT username, password, enabled FROM user WHERE username=?";
        // Check what authorities the user has
        String authQuery = "SELECT username, role FROM user WHERE username=?";
        auth
        .jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery(userQuery)
        .authoritiesByUsernameQuery(authQuery)
        .passwordEncoder(encoder);
    }
    
}