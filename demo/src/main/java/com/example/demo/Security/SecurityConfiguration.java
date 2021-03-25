package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

	
	@Value("${security.user}")
	private String user;

	@Value("${security.encodedPassword}")
	private String encodedPassword;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		auth.inMemoryAuthentication().withUser("user")
			.password(encoder.encode("pass")).roles("USER");

		auth.inMemoryAuthentication().withUser("admin")
			.password(encoder.encode("adminpass")).roles("USER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/bienvenidoI").permitAll();
		http.authorizeRequests().antMatchers("/bienvenido").permitAll();
		http.authorizeRequests().antMatchers("/newuser").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/paginaprincipal").permitAll();
		
		http.authorizeRequests().antMatchers("/{curso}/examen").permitAll();
		http.authorizeRequests().antMatchers("/{curso}/examen/completado").permitAll();
		http.authorizeRequests().antMatchers("/chatsProfesor/{idChat}").permitAll();
		http.authorizeRequests().antMatchers("/paginaprincipal").permitAll();
		http.authorizeRequests().antMatchers("/paginaprincipal").permitAll();
		http.authorizeRequests().antMatchers("/paginaprincipal").permitAll();

		// Private pages (all other pages)
		http.authorizeRequests().anyRequest().authenticated();

		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/private");
		http.formLogin().failureUrl("/loginerror");

		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");

		// Disable CSRF at the moment
		http.csrf().disable();
	}
}
