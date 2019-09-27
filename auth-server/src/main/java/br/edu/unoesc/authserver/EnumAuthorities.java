package br.edu.unoesc.authserver;

import org.springframework.security.core.GrantedAuthority;

public enum EnumAuthorities implements GrantedAuthority {
    ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}