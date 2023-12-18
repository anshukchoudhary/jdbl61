package com.example.jbdl.demosecuritydb;

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

    // developer
    // devops

    @Value("${user.authority.developer}")
    private String DEVELOPER_AUTHORITY;

    @Value("${user.authority.devops}")
    private String DEVOPS_AUTHORITY;


    @Autowired
    private UserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.

                httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers("/devops/**").hasAuthority(DEVOPS_AUTHORITY)
                .antMatchers(HttpMethod.POST, "/developer/**").hasAuthority(DEVOPS_AUTHORITY)
                .antMatchers("/developer/**").hasAuthority(DEVELOPER_AUTHORITY)
                .antMatchers("/signup/**").permitAll()
                .and()
                .formLogin();
    }

    //req1 client req came to backend --- backend will attach token t1 to client req
    //req 2 client sent another request he should be bring same token 
    //in between some token details were manitpulated then it will a csrf forgery 
  


    @Bean
    public PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
