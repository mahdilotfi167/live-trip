package co.live.trip.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import co.live.trip.model.User;

public interface UserService extends UserDetailsService {
    public void addUser(User user);
}
