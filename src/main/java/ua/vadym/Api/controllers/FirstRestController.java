package ua.vadym.Api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  //@Controller + @ResponsBody under each method
@RequestMapping("/api")
public class FirstRestController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello World!";
    }
}
