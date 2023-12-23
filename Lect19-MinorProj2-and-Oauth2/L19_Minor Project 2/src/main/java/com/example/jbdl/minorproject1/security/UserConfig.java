package com.example.jbdl.minorproject1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig extends WebSecurityConfigurerAdapter {

    // STUDENT
    // ADMIN | LIBRARIAN

    @Value("${user.authority.student}")
    private String studentAuthority;

    @Value("${user.authority.admin}")
    private String adminAuthority;

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic().and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET,"/book/**").hasAnyAuthority(adminAuthority, studentAuthority)
                .antMatchers("/book/**").hasAuthority(adminAuthority)
                .antMatchers(HttpMethod.GET,"/transaction/**").hasAnyAuthority(adminAuthority, studentAuthority)
                .antMatchers("/transaction/**").hasAuthority(studentAuthority)
                .antMatchers(HttpMethod.POST, "/student/**").permitAll()
                .antMatchers("/studentById/**", "/student/all/**").hasAuthority(adminAuthority)
                .antMatchers("/student/**").hasAuthority(studentAuthority)
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
