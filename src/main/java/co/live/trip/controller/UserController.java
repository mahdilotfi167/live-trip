package co.live.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.live.trip.model.User;
import co.live.trip.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String register() {
        return "register";
    }

    @PostMapping("/signup")
    public String processSignup(String username, String fullname, String password, String phone) {
        this.service.addUser(new User(fullname, username, password, phone));
        return "redirect:/user/login";
    }
}
