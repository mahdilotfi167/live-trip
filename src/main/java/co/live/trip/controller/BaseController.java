package co.live.trip.controller;

import org.springframework.security.core.context.SecurityContextHolder;

import co.live.trip.model.User;

public class BaseController {
    protected User getUser() {
        Object res = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (res instanceof User)
            return (User) res;
        return null;
    }

    protected boolean isAuthenticated() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User;
    }
}
