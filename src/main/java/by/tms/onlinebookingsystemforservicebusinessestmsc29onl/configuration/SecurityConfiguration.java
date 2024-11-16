package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.configuration;


import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.filter.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final SecurityProblemSupport problemSupport;

    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfiguration(JwtRequestFilter jwtRequestFilter, SecurityProblemSupport problemSupport) {
        this.jwtRequestFilter = jwtRequestFilter;
        this.problemSupport = problemSupport;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Отключаем CSRF для REST API
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Без состояния
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.POST, "/api/users/**", "/api/auth/**").permitAll().requestMatchers("/api/**").authenticated().anyRequest().permitAll()); // Требовать авторизацию для всех других запросов


        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // Добавляем фильтр JWT
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
