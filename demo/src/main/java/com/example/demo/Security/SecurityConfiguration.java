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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// PÁGINAS PÚBLICAS
		
		// Página de inicio, página principal y login
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/bienvenido").permitAll();
		http.authorizeRequests().antMatchers("/newuser").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		http.authorizeRequests().antMatchers("/paginaprincipal").permitAll();
		
		// Cursos
		http.authorizeRequests().antMatchers("/cursosDisponibles").permitAll();
		http.authorizeRequests().antMatchers("/curso/{index}").permitAll();
		
		// Foros
		http.authorizeRequests().antMatchers("/foros").permitAll();
		http.authorizeRequests().antMatchers("/foros/{IDForo}").permitAll();
		http.authorizeRequests().antMatchers("/foros/{IDForo}/respuesta").permitAll();
		http.authorizeRequests().antMatchers("/foros/nuevoforo/creado").permitAll();
		
		// Anuncios
		http.authorizeRequests().antMatchers("/anuncios").permitAll();
		http.authorizeRequests().antMatchers("/anuncios/{IDAnuncio}").permitAll();
	
		// Cursos - Profesor
		http.authorizeRequests().antMatchers("/eliminarCurso/{index}").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/crearCurso").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/{id}/añadirMaterial").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/{id}/materialSubido").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/crearCursoConfirmacion").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/{curso}/crearExamen").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/{curso}/examencreado").hasAnyRole("PROFESOR");
				
		// Chats - Profesor
		http.authorizeRequests().antMatchers("/chatsProfesor").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/chatsProfesor/{idChat}").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/chatsProfesor/{idChat}/send").hasAnyRole("PROFESOR");			
		
		// Anuncios - Profesor
		http.authorizeRequests().antMatchers("/crearAnuncio").hasAnyRole("PROFESOR");
		http.authorizeRequests().antMatchers("/anuncioCreado").hasAnyRole("PROFESOR");
		
		// Administrador
		http.authorizeRequests().antMatchers("/administrador").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/profesorAgregado").hasAnyRole("ADMIN");
		
		// Perfil - Usuario Registrado
		http.authorizeRequests().antMatchers("/modifyUser").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/deleteUser").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/profile").hasAnyRole("USER");
		
		// Examen - Usuario Registrado
		http.authorizeRequests().antMatchers("/{curso}/examen").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/{curso}/examen/completado").hasAnyRole("USER");
		
		
		// Chats - Usuario Registrado
		http.authorizeRequests().antMatchers("/chat/{profesor}").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/chat/{profesor}/send").hasAnyRole("USER");
		
		
		
		// PÁGINAS PRIVADAS		
		
		//Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("correo");
		http.formLogin().passwordParameter("contrasena");
		http.formLogin().defaultSuccessUrl("/paginaprincipal");
		http.formLogin().failureUrl("/");

		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");
		
		http.authorizeRequests().anyRequest().authenticated();	
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authenticationProvider);
	}
}
