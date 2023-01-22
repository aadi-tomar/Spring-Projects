package com.aadi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class TestController {

    @RequestMapping("/testSession")
    public String hello(Model model, HttpServletRequest request){
        model.addAttribute("next", "/second");
        HttpSession session= request.getSession();
        session.setAttribute("address", "gzb");
        return "first-page";
    }

    @RequestMapping("/second")
    public String hello1(Model model, HttpServletRequest request){
        model.addAttribute("next", "/third");
        return "first-page";
    }

    @RequestMapping("/third")
    public String hello2(Model model, HttpSession session, SessionStatus status){
        model.addAttribute("next", "/normal");
        status.setComplete();
        String res = (String)session.getAttribute("address");
        model.addAttribute("address", res + " Sweet Home");
        session.setAttribute("address", res + "Sweet Home");
        return "first-page";
    }
}
