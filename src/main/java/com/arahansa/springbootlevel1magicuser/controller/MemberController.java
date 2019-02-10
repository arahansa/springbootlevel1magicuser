package com.arahansa.springbootlevel1magicuser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    // /member
    @GetMapping
    public String index(){
        return "member";
    }

}
