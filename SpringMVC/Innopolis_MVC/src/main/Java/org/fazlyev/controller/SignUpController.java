package org.fazlyev.controller;


import org.fazlyev.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.fazlyev.services.SignUpService;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    //Благодаря аннотации @GetMapping("/signUp"),наш метод сработает,когда придет запрос
    // https://some-url/signUp
    //@RequestMapping(name = "/signUp", method = RequestMethod.GET)
    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(AccountDTO accountDTO){
        signUpService.signUp(accountDTO);
        return "redirect:/signIn";
    }
}
