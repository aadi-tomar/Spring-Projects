package com.aadi.controller;

import com.aadi.DTO.UserInfoDTO;
import com.aadi.DTO.UserRegistrationDTO;
import com.aadi.Validator.EmailValidator;
import com.aadi.Validator.UserNameValidator;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
    public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO, BindingResult result){

        System.out.println(userInfoDTO.isTermsAndConditions());
        if(result.hasErrors()){
            System.out.println("Errors are present");
            return "home-page";
        }
        System.out.println("No errors are present");
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

    @InitBinder
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
