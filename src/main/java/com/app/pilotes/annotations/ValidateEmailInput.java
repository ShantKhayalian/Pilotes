package com.app.pilotes.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


import static java.lang.annotation.ElementType.*;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidate.class)
public @interface ValidateEmailInput {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}