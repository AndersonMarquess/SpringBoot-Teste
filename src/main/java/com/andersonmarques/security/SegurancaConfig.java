package com.andersonmarques.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.andersonmarques.service.UsuarioAutenticavelService;

/**
 * Classe responsável por conter todas as configurações de segurança.
 * 
 * @author Anderson Marques
 *
 */
@Configuration
public class SegurancaConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioAutenticavelService usuarioAutenticavelService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/cadastrar", "/adicionar").permitAll()
				.antMatchers("/**/listar").hasAnyRole("USER") //Apenas usuário com role user
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioAutenticavelService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
