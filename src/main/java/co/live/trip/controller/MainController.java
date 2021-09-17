package co.live.trip.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.live.trip.model.User;

@Controller
public class MainController extends BaseController {
    @GetMapping("/")
    public String index() {
        if (isAuthenticated())
            return "redirect:/dashboard";
        return "index";
    }
}
