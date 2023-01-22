package com.aadi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Test2Controller {

    @RequestMapping("/normal")
    public String normalCall(Model model, HttpSession session){

        String res = (String)session.getAttribute("address");
        System.out.println(res);
        model.addAttribute("address", "Bamnauli Home" + res);
        return "first-page";
    }
}
