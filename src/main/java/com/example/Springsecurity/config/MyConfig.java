package com.example.Springsecurity.config;

import com.example.Springsecurity.service.UserConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity


public class MyConfig extends WebSecurityConfigurerAdapter  {
    @Bean
    public UserDetailsService getUserDetailService(){
        return new UserConfigImpl();
    }
    @Bean
public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();//PASSING OBJECT OF BCryptpasswordEncoder
}
@Bean
public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.getUserDetailService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
}
///CONFIGURE METHOD

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   auth.authenticationProvider(authenticationProvider());
   //IF WE DONT WANT TO USE DATABASE INSTEAD WE WANT INMEMORY AUTHENTICATION WE USE
     //auth.inMemoryAuthentication();
    }

    //BY USING THIS WE ARE TELLING SPRING WHICH URL WE NEED TO SECURED
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/**").permitAll().and().formLogin()
//                .and()
////
//                .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .and()
                .logout() // Adding logout configurations here
                .logoutUrl("/logout") // Custom logout URL
                .logoutSuccessUrl("/login?logout") // Redirect after successful logout
//                .invalidateHttpSession(true) // Invalidate session on logout
//                .deleteCookies("JSESSIONID") // Delete session cookie
                .permitAll() // Allow access to anyone for the logout URL
                .and()
                .csrf().disable(); // Disable CSRF protection
    }
}
