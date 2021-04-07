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

import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;

@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("**************************");
		System.out.println("He llegado al authenticate");
		System.out.println("**************************");
		
		Optional<Usuario> usuario = userRepository.findByCorreo(authentication.getName());
		
		System.out.println("**************************");
		System.out.println(usuario.get().getCorreo());
		System.out.println("**************************");
		
		if (usuario == null) {
			//System.out.print("");
			throw new BadCredentialsException("El usuario no existe");
		}
		
		String password = (String) authentication.getCredentials();
		
		// LA CONTRASEÑA DEBERÍA ESTAR ENCRIPTADA: usuario.get().getContraseñaHash()
		if (! new BCryptPasswordEncoder().matches(password, usuario.get().getContraseña())) {
			throw new BadCredentialsException("La contraseña es incorrecta");
		}
		
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for (String rol: usuario.get().getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol));
		}
		
		return new UsernamePasswordAuthenticationToken(usuario.get().getNombre(), password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return false;
	}
	
	
	
}
