package me.saechimdaeki.security.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @GetMapping("/messages")
    public String messages(){
        return "user/messages";
    }


    @GetMapping("/api/messages")
    public String apiMessage(){
        return "messages ok";
    }
}
