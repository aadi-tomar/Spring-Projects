package com.aadi.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int lower() default 18;
    int upper() default 60;
    String message() default "{invalidAgeMessage}";
}
