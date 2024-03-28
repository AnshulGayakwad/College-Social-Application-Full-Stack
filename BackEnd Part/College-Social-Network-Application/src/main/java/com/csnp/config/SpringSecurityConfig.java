//package com.csnp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SpringSecurityConfig {
//    @Bean
//    public static PasswordEncoder passwordEncoder (){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf((csrf) -> csrf.disable())
//                .authorizeHttpRequests((authorize) -> {
//                    authorize.requestMatchers(HttpMethod.POST, "/admin/**").hasRole("ADMIN");
//                    authorize.requestMatchers(HttpMethod.PUT, "/admin/**").hasRole("ADMIN");
//                    authorize.requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN");
//                    authorize.requestMatchers(HttpMethod.DELETE, "/admin/**").hasRole("ADMIN");
//                    authorize.anyRequest().authenticated();
//                }).httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails anshul = User.builder()
//                .username("anshul")
//                .password(passwordEncoder().encode("pass"))
//                .roles("SUPER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(anshul, admin);
//    }
//}
