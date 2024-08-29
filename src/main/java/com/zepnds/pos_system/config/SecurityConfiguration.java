package com.zepnds.pos_system.config;

import com.zepnds.pos_system.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.zepnds.pos_system.user.Permission.ADMIN_CREATE;
import static com.zepnds.pos_system.user.Permission.ADMIN_DELETE;
import static com.zepnds.pos_system.user.Permission.ADMIN_READ;
import static com.zepnds.pos_system.user.Permission.ADMIN_UPDATE;
import static com.zepnds.pos_system.user.Permission.MANAGER_CREATE;
import static com.zepnds.pos_system.user.Permission.MANAGER_DELETE;
import static com.zepnds.pos_system.user.Permission.MANAGER_READ;
import static com.zepnds.pos_system.user.Permission.MANAGER_UPDATE;
import static com.zepnds.pos_system.user.Permission.MERCHANT_CREATE;
import static com.zepnds.pos_system.user.Permission.MERCHANT_DELETE;
import static com.zepnds.pos_system.user.Permission.MERCHANT_READ;
import static com.zepnds.pos_system.user.Permission.MERCHANT_UPDATE;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {"/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
                                .requestMatchers("/api/v1/management/**").hasAnyRole(Role.ADMIN.name(), Role.MANAGER.name())
                                .requestMatchers(GET, "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
                                .requestMatchers(POST, "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
                                .requestMatchers(PUT, "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
                                .requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
                                .requestMatchers("/api/v1/merchant/**").hasAnyRole(Role.MERCHANT.name(), Role.MANAGER.name())
                                .requestMatchers(GET, "/api/v1/merchant/**").hasAnyAuthority(MERCHANT_READ.name())
                                .requestMatchers(POST, "/api/v1/merchant/**").hasAnyAuthority(MERCHANT_CREATE.name())
                                .requestMatchers(PUT, "/api/v1/merchant/**").hasAnyAuthority(MERCHANT_UPDATE.name())
                                .requestMatchers(DELETE, "/api/v1/merchant/**").hasAnyAuthority(MERCHANT_DELETE.name())
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/api/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;

        return http.build();
    }
}
