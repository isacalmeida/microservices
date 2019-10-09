package br.edu.unoesc.uiservice.application.security;

import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class UsuarioBean {

	private String usuario;
	private String senha;
	private String role;
	
	public UsuarioBean() {
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
