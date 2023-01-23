package com.aadi.controller;

import com.aadi.DTO.WebsiteInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ControllerAdvice(assignableTypes = TestController.class)
public class ShowController {

    @RequestMapping("/showInfo")
    public String getShow(Model model){
        System.out.println("@RequestMapping : inside getShow()");
        WebsiteInfoDTO websiteInfoDTO = (WebsiteInfoDTO) model.getAttribute("websiteInfo");
        System.out.println(websiteInfoDTO.getWebsiteCategory() + " " + websiteInfoDTO.getWebsiteName());
        return "index";
    }

    @RequestMapping("/moreInfo")
    public String showMoreInfo(){
        System.out.println("@RequestMapping : inside showMoreInfo()");
        return "index";
    }

    @ModelAttribute("websiteInfo")
    public WebsiteInfoDTO information(){
        System.out.println("@ModelAttribute : inside websiteInfo information");
        WebsiteInfoDTO websiteInfoDTO = new WebsiteInfoDTO();
        websiteInfoDTO.setWebsiteCategory("Education");
        websiteInfoDTO.setWebsiteName("FirstWebSite");
        return websiteInfoDTO;
    }
}
