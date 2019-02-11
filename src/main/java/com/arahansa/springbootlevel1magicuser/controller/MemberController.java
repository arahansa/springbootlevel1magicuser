package com.arahansa.springbootlevel1magicuser.controller;

import com.arahansa.springbootlevel1magicuser.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    List<Member> memberList = new ArrayList<>();

    // /member
    @GetMapping
    public String index(Model model){
        model.addAttribute("list", memberList);
        model.addAttribute("member", new Member());
        return "member";
    }

    @PostMapping
    public String create(@Valid Member member, BindingResult bindingResult, Model model){
        log.info("member : {}", member);
        if(bindingResult.hasErrors()){
            model.addAttribute("member", member);
            return "member";
        }
        memberList.add(member);
        return "redirect:/member";
    }

}
