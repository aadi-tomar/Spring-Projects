package com.aadi.controller;

import com.aadi.DTO.UserInfoDTO;
import com.aadi.DTO.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LCAppController {

    @RequestMapping("/")
    public String showHomePage(@ModelAttribute("userInfo") UserInfoDTO userInfoDTO){
        /*
        UserInfoDTO userInfo = new UserInfoDTO();
        model.addAttribute("userInfo", userInfo);

         */


        return "home-page";
    }

    @RequestMapping("/process-homepage")
    public String showResultPage( @ModelAttribute("userInfo") UserInfoDTO userInfoDTO){

        //model.addAttribute("userInfo", userInfoDTO);
        //model.addAttribute("userName", userInfoDTO.getUserName());
        //model.addAttribute("crushName", userInfoDTO.getCrushName());
        return "result-page";

    }


    @RequestMapping("/register")
    public String showRegistrationPage( @ModelAttribute("userRegistration") UserRegistrationDTO userRegistrationDTO){

        return "user-registration-page";
    }

    @RequestMapping("/registration-success")
    public String processUserReg(@ModelAttribute("userRegistration") UserRegistrationDTO userRegistrationDTO){
        return "registration-success";
    }
}
