package com.RBAC_System.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests((requests) ->requests
                .requestMatchers("/user/**","/role/**", "/perm/**").hasRole("ADMIN")
                .requestMatchers("/user/all","/role/all","/perm/**").hasRole("SUPERVISOR")
                .requestMatchers("/perm/**").hasRole("STAFF")
                .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }


    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN", "SUPERVISOR","STAFF")
                .build();

        UserDetails supervisor = User.withUsername("supervisor")
                .password(passwordEncoder.encode("supervisor123"))
                .roles("SUPERVISOR","STAFF")
                .build();

        UserDetails staff = User.withUsername("staff")
                .password(passwordEncoder.encode("staff123"))
                .roles("STAFF")
                .build();


        return  new InMemoryUserDetailsManager(admin,staff,supervisor);
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
