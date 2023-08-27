package com.example.project.configuration;

import com.example.project.model.Administrator;
import com.example.project.model.Student;
import com.example.project.model.Teacher;
import com.example.project.persistance.AdministratorRepository;
import com.example.project.persistance.StudentRepository;
import com.example.project.persistance.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {
    private final StudentRepository studentRepository;
    private final AdministratorRepository administratorRepository;
    private final TeacherRepository teacherRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Student student = studentRepository.findByUsername(username).orElse(null);
                Teacher teacher = teacherRepository.findByUsername(username).orElse(null);
                Administrator administrator = administratorRepository.findByUsername(username).orElse(null);
                if (student == null && teacher == null && administrator != null)
                    return administrator;
                if (student != null && teacher == null && administrator == null)
                    return student;
                if (student == null && teacher != null && administrator == null)
                    return teacher;
                throw new UsernameNotFoundException("User not found");
            }
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
