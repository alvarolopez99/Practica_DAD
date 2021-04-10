package com.example.demo.Security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.Sapiotheca;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UsuarioRepository userRepository;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(Sapiotheca.class);	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		LOGGER.info("**************************");
		LOGGER.info("He llegado al authenticate");
		LOGGER.info("**************************");
		
		Optional<Usuario> usuario = userRepository.findByCorreo(authentication.getName());
		
		if(usuario.isPresent()) {
			LOGGER.info("**************************");
			LOGGER.info("Usuario: " + usuario.get().getCorreo());
			LOGGER.info("**************************");
		} else {
			throw new BadCredentialsException("El usuario no existe");
		}
		
		
		String password = (String) authentication.getCredentials();
		
		LOGGER.info("**************************");
		LOGGER.info("Contraseña BD: " + usuario.get().getContraseña());
		LOGGER.info("**************************");
		
		LOGGER.info("**************************");
		LOGGER.info("Contraseña introducida: " + password);
		LOGGER.info("**************************");
		
		// LA CONTRASEÑA DEBERÍA ESTAR ENCRIPTADA: usuario.get().getContraseñaHash()
		if (! new BCryptPasswordEncoder().matches(password, usuario.get().getContraseña())) {
			throw new BadCredentialsException("La contraseña es incorrecta");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		for (String rol: usuario.get().getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol));
		}
		
		return new UsernamePasswordAuthenticationToken(usuario.get().getCorreo(), password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return true;
	}


	
	
	
}
