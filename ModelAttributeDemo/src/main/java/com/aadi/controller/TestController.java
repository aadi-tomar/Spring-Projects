package com.aadi.controller;

import com.aadi.DTO.WebsiteInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String testShow(Model model){
        System.out.println("@RequestMapping : inside getShow()");
        WebsiteInfoDTO websiteInfoDTO = (WebsiteInfoDTO) model.getAttribute("websiteInfo");
        System.out.println(websiteInfoDTO.getWebsiteCategory() + " " + websiteInfoDTO.getWebsiteName());
        return "index";
    }

}
