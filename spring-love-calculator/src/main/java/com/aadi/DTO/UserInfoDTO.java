package com.aadi.DTO;

import javax.validation.constraints.*;

public class UserInfoDTO {

    @NotBlank(message = "* UserName cant be blank")
    @Size(min = 3, max = 15, message = "* Your name should have char between 3 and 15")
    private String userName;
    @NotBlank(message = "* Crush name cant be blank")
    @Size(min = 3, max = 15, message = "* Your name should have char between 3 and 15")
    private String crushName;
    @AssertTrue(message = "You have to agree to proceed further")
    private boolean termsAndConditions;


    public boolean isTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(boolean termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCrushName() {
        return crushName;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }
}
