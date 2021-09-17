package co.live.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends BaseController {
    @GetMapping
    public ModelAndView dashboard() {
        ModelAndView res = new ModelAndView("dashboard");
        res.addObject("user", getUser());
        return res;
    }
}
