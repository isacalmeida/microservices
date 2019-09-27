package br.edu.unoesc.authserver;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usu_usuario")
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;

	// == primary-fields ==
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
	private Long id;
	
	@Column(name = "usu_username", length = 50)
	private String username;
	
	@Column(name = "usu_password", length = 50)
	private String password;
	
	@Column(name = "usu_activated")
	private Boolean activated;
	
	@Column(name = "usu_activation_key", length = 250)
	private String activationKey;
	
	@Column(name = "usu_reset_password_key", length = 250)
	private String resetPasswordKey;
	
	private Set<EnumAuthorities> authorities = new HashSet<>();

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
