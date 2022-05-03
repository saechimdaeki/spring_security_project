package me.saechimdaeki.security.controller.user;

import lombok.RequiredArgsConstructor;
import me.saechimdaeki.security.domain.AccountDto;
import me.saechimdaeki.security.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {


    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @GetMapping("/mypage")
    public String myPage(){
        return "user/mypage";
    }


    @GetMapping("/users")
    public String createUser(){
        return "user/login/register";
    }

    @PostMapping("/users")
    public String createUser(AccountDto accountDto){
        accountDto.changePassword(passwordEncoder.encode(accountDto.getPassword()));
        userService.createUser(accountDto);
        return "redirect:/";
    }
}
