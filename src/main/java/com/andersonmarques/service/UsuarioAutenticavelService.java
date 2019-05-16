package com.andersonmarques.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.andersonmarques.model.Permissao;
import com.andersonmarques.model.Usuario;
import com.andersonmarques.repository.PermissaoRepository;
import com.andersonmarques.repository.UsuarioRepository;

/**
 * Classe para fazer todo gerenciamento de dados para usuários com autênticação.
 * 
 * @author Anderson Marques
 *
 */
@Service
public class UsuarioAutenticavelService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.encontrarUsuarioComNome(username);
		
		return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(usuario.getSenha())
                .authorities(getPermissoesPorIdUsuario(usuario.getId()))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
	}

	/**
	 * Retorna todas as Permissões do usuário com id especificado.
	 * @return
	 */
	private Collection<GrantedAuthority> getPermissoesPorIdUsuario(Integer id) {
		List<Permissao> permissoes = permissaoRepository.encontrarPermissoesPorIdUsuario(id);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		permissoes.forEach(
			p -> authorities.add(p::getNomePermissao)
		);
		return authorities;
	}

	public void adicionar(Usuario usuario) {
		adicionarPermissoesPadrao(usuario);
		usuarioRepository.save(usuario);
	}
	
	private void adicionarPermissoesPadrao(Usuario usuario) {
		Permissao pUser = new Permissao();
		pUser.setNomePermissao("ROLE_USER");
		pUser.adicionarUsuario(usuario);
		usuario.addPermissao(pUser);			
		permissaoRepository.save(pUser);
	}

	public Usuario encontrarUsuarioComNome(String nomeUsuario) {
		return usuarioRepository.encontrarUsuarioComNome(nomeUsuario);
	}

	public Integer getIdDoUsuarioLogado() {
		String nomeUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = usuarioRepository.encontrarUsuarioComNome(nomeUsuario);
		return usuario.getId();
	}
}
