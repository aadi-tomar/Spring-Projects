package com.aadi.controller;

import com.aadi.DTO.EmailDTO;
import com.aadi.DTO.UserInfoDTO;
import com.aadi.DTO.UserRegistrationDTO;
import com.aadi.Validator.EmailValidator;
import com.aadi.Validator.UserNameValidator;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LCAppController {

    @RequestMapping("/")
    public String showHomePage(@ModelAttribute("userInfo") UserInfoDTO userInfoDTO, HttpServletRequest request){
        /*
        UserInfoDTO userInfo = new UserInfoDTO();
        model.addAttribute("userInfo", userInfo);
         */

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("lcApp.userName")){
                String userName = cookie.getValue();
                userInfoDTO.setUserName(userName);
            }
        }
        return "home-page";
    }

    @RequestMapping("/sendEmail")
    public String sendEmail(@CookieValue("lcApp.userName") String userName, Model model ){

        //manually adding modelAttribute
        model.addAttribute("userName", userName);
        model.addAttribute("emailDTO" , new EmailDTO());
        //model.addAttribute("userName", userName.toUpperCase());
        return "send-email-page";
    }

    @RequestMapping("/processEmail")
    public String processEmail(@ModelAttribute("emailDTO") EmailDTO emailDTO){

        return "process-email-page";

    }

    @RequestMapping("/process-homepage")
    public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO,
                                 BindingResult result, HttpServletResponse response){

        //System.out.println(userInfoDTO.isTermsAndConditions());
        if(result.hasErrors()){
            System.out.println("Errors are present");
            List<ObjectError> err = result.getAllErrors();
            for(ObjectError oe : err)
                System.out.println(oe);
            return "home-page";
        }

        //Cookie to store the user info and pass to next page

        Cookie cookie = new Cookie("lcApp.userName", userInfoDTO.getUserName());
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        // write a service logic to return the result between user and crush


        //System.out.println("No errors are present");
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
    public String processUserReg(@Valid @ModelAttribute("userRegistration") UserRegistrationDTO userRegistrationDTO,
                                 BindingResult result){

        EmailValidator emailValidator = new EmailValidator();
        emailValidator.validate(userRegistrationDTO, result);
        if(result.hasErrors()){
            System.out.println("My page has errors");
            return "user-registration-page";
        }
        return "registration-success";
    }

    @InitBinder("userRegistration")
    public void initBinder(WebDataBinder binder){
        //disallowed a particular field
        //binder.setDisallowedFields("name");
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, "name", editor);

        UserNameValidator userNameValidator = new UserNameValidator();
        binder.addValidators(userNameValidator);
        /*EmailValidator emailValidator = new EmailValidator();
        binder.addValidators(emailValidator);*/

    }
}
