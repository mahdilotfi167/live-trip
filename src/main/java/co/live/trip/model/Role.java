package co.live.trip.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, DRIVER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
