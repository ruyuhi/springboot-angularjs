// Copyright (c) 2014 KMS Technology, Inc.
package ask.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import ask.springboot.security.CustomUserDetailsService;

/**
 * @author trungnguyen
 */
@Order(Ordered.LOWEST_PRECEDENCE - 8)
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Security extends WebSecurityConfigurerAdapter {
    
	
	 // @Autowired
	 // private UserDetailsService userDetailsService;
	/*
	    @Override
	    @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsService();
	    }
	    
	    
	    
	    @Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
      */
	 
	    
	    @Override
	    @Bean
	    public UserDetailsService userDetailsService() {
	        return new CustomUserDetailsService();
	        }

	    @Override  
	    protected void configure(AuthenticationManagerBuilder auth)  
	            throws Exception {  
	        auth.userDetailsService(userDetailsService());  
	    }  
	    
	    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/rest/contacts*/**").permitAll()
            .antMatchers(HttpMethod.GET, "/rest/photos*/**").permitAll()
            .antMatchers("/rest/**").authenticated()
            //.antMatchers("/countries").hasAuthority("admin")
            .antMatchers("/jsp/**").hasAuthority("admin")
            .anyRequest().permitAll();
    }
}
