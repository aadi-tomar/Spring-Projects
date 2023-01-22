package com.aadi.Validator;

import com.aadi.DTO.UserRegistrationDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserNameValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistrationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        // to check if the field is empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName", "userName.empty", "User Name can't be empty" );

        //the string should conttain a _
        String userName = ((UserRegistrationDTO)o).getUserName();
        if(!userName.contains("_")){
            errors.rejectValue("userName", "userName.empty", "String must contain a _");
        }

    }
}
