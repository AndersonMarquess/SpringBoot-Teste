package com.andersonmarques.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * [EM CONSTRUÇÃO] 
 * 
 * @author Anderson Marques
 *
 */
@Service
public class UsuarioAutenticavelService implements UserDetailsService {
	
	//@Autowired
	//private UsuarioAutenticavelRepository usuarioAutenticavelRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//Autenticavel usuario = usuarioAutenticavelRepository.encontrarUsuarioComNome(username);
		//Verificar se é nulo
		
		return org.springframework.security.core.userdetails.User
                .withUsername(username)
                //.password(usuario.getPassword())
                .authorities(getAuthoritiesByName(username))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
	}

	/**
	 * Retorna todas as autoridades do usuário.
	 * @return
	 */
	private Collection<GrantedAuthority> getAuthoritiesByName(String username) {
//		usuarioAutenticavelRepository.encontrarAutoridadesPorNome(username);
//		Collection<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(() -> "ROLE_USER");
//		authorities.add(() -> "ROLE_ADMIN");
		return null;
	}
}
