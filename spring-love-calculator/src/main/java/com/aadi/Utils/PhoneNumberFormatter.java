package com.aadi.Utils;

import com.aadi.DTO.Phone;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneNumberFormatter implements Formatter<Phone> {


    @Override
    public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
        System.out.println("Inside the parse method of PhoneNumberFormatter ");
        String[] phoneNumberArray = completePhoneNumber.split("-");
        Phone phone = new Phone();
        int index = completePhoneNumber.indexOf("-");
        if(index ==-1 || completePhoneNumber.startsWith("-")){
            phone.setCountryCode("91");
            if(completePhoneNumber.startsWith("-"))
                phone.setUserNumber(phoneNumberArray[1]);
            else
                phone.setUserNumber(phoneNumberArray[0]);
        }
        else {
            phone.setUserNumber(phoneNumberArray[1]);
            phone.setCountryCode(phoneNumberArray[0]);
        }
        return phone;
    }


    @Override
    public String print(Phone phone, Locale locale) {
        return phone.getCountryCode() + "-" + phone.getUserNumber();
    }
}
