package com.aadi.Validator;

import com.aadi.DTO.UserRegistrationDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmailValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistrationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty");
        String email = ((UserRegistrationDTO)o).getCommunicationDTO().getEmail();
        if(!email.endsWith("gmail.com")){
            errors.rejectValue("communicationDTO.email", "email.invalidDomain");
        }
    }
}
