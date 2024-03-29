package com.ssw.ist.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	 @Override
	    public void configure(HttpSecurity http) throws Exception {
	        http.
	                anonymous().disable()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
	                .antMatchers("/admin/**").hasRole("ADMIN")
	                .antMatchers("/api/**").authenticated()
	                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	    }
	 
	 
}
