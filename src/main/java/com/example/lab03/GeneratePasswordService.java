package com.example.lab03;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratePasswordService {
    private String password;
    @RequestMapping(value = "{name}.generate", method = RequestMethod.GET)
    public String generate(@PathVariable("name") String name){
        password = String.valueOf(Math.round(Math.random()*100000000));
        return "Hi, " + name + "\nYour new password is " + password + ".";
    }
}
