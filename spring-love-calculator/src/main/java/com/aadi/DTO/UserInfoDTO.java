package com.aadi.DTO;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserInfoDTO {

    @NotBlank(message = "UserName cant be blank")
    private String userName;
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
