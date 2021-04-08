package com.example.demo.Security;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

	/*
	@Value("${security.user}")
	private String user;

	@Value("${security.encodedPassword}")
	private String encodedPassword;
	*/
	
	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}
	*/
	
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// PÁGINAS PÚBLICAS
		
		// Página de inicio, página principal y login
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/bienvenidoI").permitAll();
		http.authorizeRequests().antMatchers("/bienvenido").permitAll();
		http.authorizeRequests().antMatchers("/newuser").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/paginaprincipal").permitAll();
		
		
		//http.authorizeRequests().antMatchers("/administrador").permitAll();
		//http.authorizeRequests().antMatchers("/profesorAgregado").permitAll();
		
		// Cursos
		http.authorizeRequests().antMatchers("/cursosDisponibles").permitAll();
		http.authorizeRequests().antMatchers("/curso/{index}").permitAll();
		http.authorizeRequests().antMatchers("/{id}/materialSubido").permitAll();
		
		// Foros
		http.authorizeRequests().antMatchers("/foros").permitAll();
		http.authorizeRequests().antMatchers("/foros/{IDForo}").permitAll();
		http.authorizeRequests().antMatchers("/foros/{IDForo}/respuesta").permitAll();
		
		// Anuncios
		http.authorizeRequests().antMatchers("/anuncios").permitAll();
		http.authorizeRequests().antMatchers("/anuncios/{IDAnuncio}").permitAll();
	
		
		
		
		
		// Cursos - Profesor
		http.authorizeRequests().antMatchers("/eliminarCurso/{index}").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/crearCurso").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/{id}/añadirMaterial").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/crearCursoConfirmacion").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/{curso}/examencreado").hasAnyRole("PROFESOR");
				
		// Chats - Profesor
		http.authorizeRequests().antMatchers("/chatsProfesor").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/chatsProfesor/{idChat}").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/chatsProfesor/{idChat}/send").hasAnyRole("PROFESOR");			
		
		// Anuncios - Profesor
		http.authorizeRequests().antMatchers("/crearAnuncio").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/anuncioCreado").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/eliminarAnuncio/{index}").hasAnyRole("PROFESOR");
		
		// Administrador
		http.authorizeRequests().antMatchers("/administrador").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/profesorAgregado").hasAnyRole("ADMIN");
		
		// Perfil - Usuario Registrado
		http.authorizeRequests().antMatchers("/modifyUser").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/profile").hasAnyRole("USER");
		
		// Examen - Usuario Registrado
		http.authorizeRequests().antMatchers("/{curso}/examen").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/{curso}/examen/completado").hasAnyRole("USER");
		
		// Foros - Usuario Registrado y Profesor
		//http.authorizeRequests().antMatchers("/foros/{IDForo}").hasAnyRole("user", "profesor");
		//http.authorizeRequests().antMatchers("/foros/{IDForo}/respuesta").hasAnyRole("user", "profesor");
		
		// Chats - Usuario Registrado
		http.authorizeRequests().antMatchers("/chat/{profesor}").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/chat/{profesor}/send").hasAnyRole("USER");
		
		// PÁGINAS PRIVADAS
		
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("correo");
		http.formLogin().passwordParameter("contrasena");
		http.formLogin().defaultSuccessUrl("/paginaprincipal");
		
		// COMPLETAR:
		//http.formLogin().defaultSuccessUrl("/private");
		//http.formLogin().failureUrl("/loginerror");

		// Logout
		http.logout().logoutUrl("/sesion_cerrada");
		http.logout().logoutSuccessUrl("/");
		
		http.authorizeRequests().anyRequest().authenticated();	
		// Disable CSRF at the moment
		//http.csrf().disable();
		
	}
	
	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authenticationProvider).passwordEncoder(passwordEncoder());
	}*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		auth.inMemoryAuthentication().withUser("aaa@aaa.aaa")
			.password(encoder.encode("aaa")).roles("USER");

		auth.inMemoryAuthentication().withUser("admin")
			.password(encoder.encode("adminpass")).roles("USER", "ADMIN");
		
		auth.inMemoryAuthentication().withUser("teacher")
		.password(encoder.encode("teacherpass")).roles("PROFESOR");*/
		
		// ¿COMPATIBLE CON LO ANTERIOR?
		auth.authenticationProvider(authenticationProvider);
	}
}
