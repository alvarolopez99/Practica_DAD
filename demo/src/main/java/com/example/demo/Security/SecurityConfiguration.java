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
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		auth.inMemoryAuthentication().withUser("user")
			.password(encoder.encode("pass")).roles("usuario_Registrado");

		auth.inMemoryAuthentication().withUser("admin")
			.password(encoder.encode("adminpass")).roles("usuario_Registrado", "administrador");
		
		auth.inMemoryAuthentication().withUser("teacher")
		.password(encoder.encode("teacherpass")).roles("profesor");
	}
	
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
	
		
		
		// PÁGINAS PRIVADAS
		http.authorizeRequests().anyRequest().authenticated();
		
		// Cursos - Profesor
		http.authorizeRequests().antMatchers("/eliminarCurso/{index}").hasAnyRole("profesor");
		http.authorizeRequests().antMatchers("/crearCurso").hasAnyRole("profesor");
		http.authorizeRequests().antMatchers("/{id}/añadirMaterial").hasAnyRole("profesor");
		http.authorizeRequests().antMatchers("/crearCursoConfirmacion").hasAnyRole("profesor");
		http.authorizeRequests().antMatchers("/{curso}/examencreado").hasAnyRole("profesor");
				
		// Chats - Profesor
		http.authorizeRequests().antMatchers("/chatsProfesor").hasAnyRole("profesor");
		http.authorizeRequests().antMatchers("/chatsProfesor/{idChat}").hasAnyRole("profesor");
		http.authorizeRequests().antMatchers("/chatsProfesor/{idChat}/send").hasAnyRole("profesor");			
		
		// Anuncios - Profesor
		http.authorizeRequests().antMatchers("/crearAnuncio").hasAnyRole("profesor");
		http.authorizeRequests().antMatchers("/anuncioCreado").hasAnyRole("profesor");
		http.authorizeRequests().antMatchers("/eliminarAnuncio/{index}").hasAnyRole("profesor");
		
		// Administrador
		http.authorizeRequests().antMatchers("/administrador").hasAnyRole("administrador");
		http.authorizeRequests().antMatchers("/profesorAgregado").hasAnyRole("administrador");
		
		// Perfil - Usuario Registrado
		http.authorizeRequests().antMatchers("/modifyUser").hasAnyRole("usuario_Registrado");
		http.authorizeRequests().antMatchers("/profile").hasAnyRole("usuario_Registrado");
		
		// Examen - Usuario Registrado
		http.authorizeRequests().antMatchers("/{curso}/examen").hasAnyRole("usuario_Registrado");
		http.authorizeRequests().antMatchers("/{curso}/examen/completado").hasAnyRole("usuario_Registrado");
		
		// Foros - Usuario Registrado y Profesor
		http.authorizeRequests().antMatchers("/foros/{IDForo}").hasAnyRole("usuario_Registrado", "profesor");
		http.authorizeRequests().antMatchers("/foros/{IDForo}/respuesta").hasAnyRole("usuario_Registrado", "profesor");
		
		// Chats - Usuario Registrado
		http.authorizeRequests().antMatchers("/chat/{profesor}").hasAnyRole("usuario_Registrado");
		http.authorizeRequests().antMatchers("/chat/{profesor}/send").hasAnyRole("usuario_Registrado");
		
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("nombreUsuario");
		http.formLogin().passwordParameter("contraseña_1");	
		
		/* COMPLETAR:
		http.formLogin().defaultSuccessUrl("/private");
		http.formLogin().failureUrl("/loginerror");

		// Logout
		http.logout().logoutUrl("/sesion_cerrada");
		http.logout().logoutSuccessUrl("/");
		

		// Disable CSRF at the moment
		http.csrf().disable();
		
	}
	*/
}
