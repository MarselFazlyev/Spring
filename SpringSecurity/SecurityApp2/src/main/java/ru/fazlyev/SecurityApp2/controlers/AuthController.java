package ru.fazlyev.SecurityApp2.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/auth")
    public String loginPage(){
        return "auth/login";
        }

}
